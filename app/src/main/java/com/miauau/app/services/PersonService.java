package com.miauau.app.services;

import com.miauau.app.entities.PersonEntity;
import com.miauau.app.entities.AssistanceNeedEntity;
import com.miauau.app.entities.HealthSituationEntity;
import com.miauau.app.entities.PersonEntity;
import com.miauau.app.repositories.PersonRepository;
import com.miauau.app.repositories.PersonRepository;
import com.miauau.app.requests.PersonRequest;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;

  @Transactional
  public List<PersonEntity> getAll() {
    return repository.findAll();
  }

  @Transactional
  public PersonEntity save(PersonRequest response) {
    PersonEntity person = new PersonEntity();
    person.setName(response.name());
    person.setDateOfBirth(response.dateOfBirth());
    person.setRg(response.rg());
    person.setCpf(response.cpf());
    person.setPhone(response.phone());
    person.setLandline(response.landline());
    person.setEmail(response.email());
    person.setProfession(response.profession());

    return repository.save(person);
  }


}


