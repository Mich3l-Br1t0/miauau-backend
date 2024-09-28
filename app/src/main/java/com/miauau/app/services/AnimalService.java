package com.miauau.app.services;

import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.entities.AssistanceNeedEntity;
import com.miauau.app.entities.HealthSituationEntity;
import com.miauau.app.repositories.AnimalRepository;
import com.miauau.app.requests.AnimalRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AnimalService {

  @Autowired
  private AnimalRepository repository;

  @Transactional
  public List<AnimalEntity> getAll() {
    return repository.findAll();
  }

  @Transactional
  public AnimalEntity getById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  @Transactional
  public AnimalEntity create(AnimalRequest response, MultipartFile image) throws IOException {
    if (!Objects.requireNonNull(image.getContentType()).startsWith("image/")) {
      throw new IllegalArgumentException("O arquivo enviado não é uma imagem válida.");
    }
    // Limite de 5MB
    if (image.getSize() > 5_000_000) {
      throw new IllegalArgumentException("O tamanho da imagem excede o limite permitido (5MB).");
    }

    AnimalEntity animal = AnimalEntity.builder()
        .name(response.name())
        .sex(response.sex())
        .description(response.description())
        .ageGroupId(response.ageGroupId())
        .castrated(response.castrated())
        .color(response.color())
        .approximatedAge(response.approximatedAge())
        .imageName(image.getOriginalFilename())
        .imageType(image.getContentType())
        .image(image.getBytes())
        .build();

    HealthSituationEntity healthSituation = HealthSituationEntity.builder()
        .healthy(response.healthy())
        .dirty(response.dirty())
        .hurt(response.hurt())
        .mange(response.mange())
        .fleas(response.fleas())
        .ticks(response.ticks())
        .vomiting(response.vomiting())
        .limping(response.limping())
        .other(response.otherHealthSituation())
        .build();
    healthSituation.setAnimal(animal);

    AssistanceNeedEntity assistanceNeed = AssistanceNeedEntity.builder()
        .veterinarian(response.veterinarian())
        .urgency(response.urgency())
        .bath(response.bath())
        .other(response.otherAssistanceNeedInfo())
        .build();
    assistanceNeed.setAnimal(animal);

    animal.setAssistanceNeed(assistanceNeed);
    animal.setHealthSituation(healthSituation);

    return repository.save(animal);
  }

  @Transactional
  public AnimalEntity update(UUID id, AnimalRequest request) {
    AnimalEntity animal = repository.findById(id).orElse(null);
    if (animal == null) {
      return null;
    }

    animal.setName(request.name());
    animal.setSex(request.sex());
    animal.setDescription(request.description());
    animal.setAgeGroupId(request.ageGroupId());
    animal.setCastrated(request.castrated());
    animal.setColor(request.color());
    animal.setApproximatedAge(request.approximatedAge());

    return repository.save(animal);
  }

  @Transactional
  public void delete(UUID id) {
    if (repository.existsById(id))
      repository.deleteById(id);
    else
      throw new IllegalArgumentException("Animal não encontrado.");
  }
}
