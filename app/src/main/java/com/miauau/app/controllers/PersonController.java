package com.miauau.app.controllers;

import com.miauau.app.entities.PersonEntity;
import com.miauau.app.requests.PersonRequest;
import com.miauau.app.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService service;

  @GetMapping
  public List<PersonEntity> getAll() {
    return service.getAll();
  }

  @GetMapping("/volunteers")
  public List<PersonEntity> getVolunteers() {
    return service.getVolunteers();
  }

  @GetMapping("/{id}")
  public PersonEntity getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  public PersonEntity save(@RequestBody PersonRequest request) {
    return service.save(request);
  }
}
