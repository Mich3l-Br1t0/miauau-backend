package com.miauau.app.controller;

import com.miauau.app.entity.AnimalEntity;
import com.miauau.app.request.AnimalRequest;
import com.miauau.app.service.AnimalService;
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
