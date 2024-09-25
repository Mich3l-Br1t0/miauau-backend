package com.miauau.app.controllers;

import com.miauau.app.entities.PersonEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateEntity;
import com.miauau.app.requests.AdoptionCandidateRequest;
import com.miauau.app.requests.PersonRequest;
import com.miauau.app.services.AdoptionCandidateService;
import com.miauau.app.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptionCandidate")
public class AdoptionCandidateController {

  @Autowired
  private AdoptionCandidateService service;

  @GetMapping
  public List<AdoptionCandidateEntity> getAll() {
    return service.getAll();
  }

  @PostMapping
  public AdoptionCandidateEntity save(@RequestBody AdoptionCandidateRequest request) {
    return service.save(request);
  }
}
