package com.miauau.app.controller;

import com.miauau.app.entity.AnimalEntity;
import com.miauau.app.repository.AnimalRepository;
import com.miauau.app.response.AnimalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  private AnimalRepository repository;

  @GetMapping
  public List<AnimalResponse> get(){
    return  repository.findAll().stream().map(AnimalResponse::new).toList();
  }

  @CrossOrigin(origins = "*", allowedHeaders = "*")
  @PostMapping
  public void save(@RequestBody AnimalResponse response) {
    AnimalEntity entity = new AnimalEntity(response);
    repository.save(entity);
  }
}
