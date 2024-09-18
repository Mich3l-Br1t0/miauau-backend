package com.miauau.app.service;

import com.miauau.app.entity.AnimalEntity;
import com.miauau.app.entity.AssistanceNeedEntity;
import com.miauau.app.entity.HealthSituationEntity;
import com.miauau.app.repository.AnimalRepository;
import com.miauau.app.request.AnimalRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

  @Autowired
  private AnimalRepository repository;

  @Transactional
  public List<AnimalEntity> getAll() {
    return repository.findAll();
  }

  @Transactional
  public AnimalEntity save(AnimalRequest response) {
    AnimalEntity animal = new AnimalEntity();
    animal.setName(response.name());
    animal.setSex(response.sex());
    animal.setDescription(response.description());
    animal.setAgeGroupId(response.ageGroupId());
    animal.setCastrated(response.castrated());
    animal.setColor(response.color());
    animal.setApproximatedAge(response.approximatedAge());

    HealthSituationEntity healthSituation = new HealthSituationEntity();
    healthSituation.setAnimal(animal);

    AssistanceNeedEntity assistanceNeed = new AssistanceNeedEntity();
    assistanceNeed.setAnimal(animal);

    animal.setAssistanceNeed(assistanceNeed);
    animal.setHealthSituation(healthSituation);
    
    return repository.save(animal);
  }


}
