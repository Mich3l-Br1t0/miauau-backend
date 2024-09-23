package com.miauau.app.controllers;

import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.request.AnimalRequest;
import com.miauau.app.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  private AnimalService service;

  @GetMapping
  public List<AnimalEntity> getAll() {
    return service.getAll();
  }

  @PostMapping
  public AnimalEntity save(@RequestBody AnimalRequest request) {
    return service.save(request);
  }
}
