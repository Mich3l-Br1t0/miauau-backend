package com.miauau.app.controllers;

import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.requests.AnimalRequest;
import com.miauau.app.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  @Autowired
  private AnimalService service;

  @GetMapping
  public List<AnimalEntity> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public AnimalEntity getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestPart AnimalRequest request, @RequestPart MultipartFile image) {
    try {
      AnimalEntity animal = service.create(request, image);
      return new ResponseEntity<>(animal, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public AnimalEntity update(@PathVariable UUID id, @RequestBody AnimalRequest request) {
    return service.update(id, request);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable UUID id) {
    try {
      service.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
