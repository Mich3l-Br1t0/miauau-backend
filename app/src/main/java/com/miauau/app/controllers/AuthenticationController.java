package com.miauau.app.controllers;

import com.miauau.app.entities.UserEntity;
import com.miauau.app.enums.UserRole;
import com.miauau.app.repositories.UserRepository;
import com.miauau.app.requests.AuthenticationRequest;
import com.miauau.app.requests.RegisterRequest;
import com.miauau.app.responses.LoginResponse;
import com.miauau.app.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserRepository repository;
  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid AuthenticationRequest data) {
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

    return ResponseEntity.ok(new LoginResponse(token));
  }

  @PostMapping("/register")
  public ResponseEntity register(@RequestBody @Valid RegisterRequest data) {
    if (this.repository.findByLogin(data.login()) != null)
      return ResponseEntity.badRequest().build();

    String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
    UserRole role = data.role() == null ? UserRole.USER : data.role();
    UserEntity newUser = new UserEntity(data.login(), encryptedPassword, role);

    this.repository.save(newUser);

    return ResponseEntity.ok().build();
  }
}