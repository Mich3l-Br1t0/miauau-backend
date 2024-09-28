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
  public PersonEntity save(PersonRequest request) {
    PersonEntity person = new PersonEntity();
    person.setName(request.name());
    person.setDateOfBirth(request.dateOfBirth());
    person.setRg(request.rg());
    person.setCpf(request.cpf());
    person.setPhone(request.phone());
    person.setLandline(request.landline());
    person.setEmail(request.email());
    person.setProfession(request.profession());

    OccupationEntity occupation = new OccupationEntity();
    occupation.setWorking(request.occupation().isWorking());
    occupation.setStudying(request.occupation().isStudying());
    occupation.setUnemployed(request.occupation().isUnemployed());
    occupation.setOther(request.occupation().getOther());

    occupation.setPerson(person);
    person.setOccupation(occupation);

    AddressEntity address = new AddressEntity();
    address.setZipCode(request.address().getZipCode());
    address.setStreet(request.address().getStreet());
    address.setNumber(request.address().getNumber());
    address.setComplement(request.address().getComplement());
    address.setNeighborhood(request.address().getNeighborhood());

    address.setPerson(person);
    person.setAddress(address);

    return repository.save(person);
  }
}


