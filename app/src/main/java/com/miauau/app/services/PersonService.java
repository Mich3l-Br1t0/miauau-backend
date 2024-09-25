package com.miauau.app.services;

import com.miauau.app.entities.AddressEntity;
import com.miauau.app.entities.OccupationEntity;
import com.miauau.app.entities.PersonEntity;
import com.miauau.app.repositories.PersonRepository;
import com.miauau.app.requests.PersonRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    OccupationEntity occupation = new OccupationEntity();
    occupation.setWorking(response.occupation().isWorking());
    occupation.setStudying(response.occupation().isStudying());
    occupation.setUnemployed(response.occupation().isUnemployed());
    occupation.setOther(response.occupation().getOther());

    occupation.setPerson(person);
    person.setOccupation(occupation);

    AddressEntity address = new AddressEntity();
    address.setZipCode(response.address().getZipCode());
    address.setStreet(response.address().getStreet());
    address.setNumber(response.address().getNumber());
    address.setComplement(response.address().getComplement());
    address.setNeighborhood(response.address().getNeighborhood());

    address.setPerson(person);
    person.setAddress(address);

    return repository.save(person);
  }
}


