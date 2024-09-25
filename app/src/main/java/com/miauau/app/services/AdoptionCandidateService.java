package com.miauau.app.services;

import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateIncomeEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateResidentsOfTheHouseEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionMotivationEntity;
import com.miauau.app.repositories.AdoptionCandidateRepository;
import com.miauau.app.requests.AdoptionCandidateRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptionCandidateService {

  @Autowired
  private AdoptionCandidateRepository repository;

  @Transactional
  public List<AdoptionCandidateEntity> getAll() {
    return repository.findAll();
  }

  @Transactional
  public AdoptionCandidateEntity save(AdoptionCandidateRequest response) {
    AdoptionCandidateEntity candidate = new AdoptionCandidateEntity();
    candidate.setPerson(response.person());
    candidate.setPossibilityOfMoving(response.possibilityOfMoving());
    candidate.setWhatHappensInCaseOfMoving(response.whatHappensInCaseOfMoving());
    candidate.setWantedAnimals(response.wantedAnimals());

    AdoptionMotivationEntity motivation = new AdoptionMotivationEntity();
    motivation.setCompany(response.motivation().isCompany());
    motivation.setGuardAndLook(response.motivation().isGuardAndLook());
    motivation.setGiftSomeone(response.motivation().isGiftSomeone());
    motivation.setOther(response.motivation().getOther());

    motivation.setCandidate(candidate);
    candidate.setMotivation(motivation);

    AdoptionCandidateIncomeEntity income = new AdoptionCandidateIncomeEntity();
    income.setFixed(response.income().isFixed());
    income.setVariable(response.income().isVariable());
    income.setDoesNotHave(response.income().isDoesNotHave());

    income.setCandidate(candidate);
    candidate.setIncome(income);

    AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse = getAdoptionCandidateResidentsOfTheHouseEntity(response, candidate);
    candidate.setResidentsOfTheHouse(residentsOfTheHouse);

    return repository.save(candidate);
  }

  private static AdoptionCandidateResidentsOfTheHouseEntity getAdoptionCandidateResidentsOfTheHouseEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate) {
    AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse = new AdoptionCandidateResidentsOfTheHouseEntity();
    residentsOfTheHouse.setLivesAlone(response.residentsOfTheHouse().isLivesAlone());
    residentsOfTheHouse.setAmountOfChildrenInTheHouse(response.residentsOfTheHouse().getAmountOfChildrenInTheHouse());
    residentsOfTheHouse.setChildrensAges(response.residentsOfTheHouse().getChildrensAges());
    residentsOfTheHouse.setAlergicResidents(response.residentsOfTheHouse().isAlergicResidents());
    residentsOfTheHouse.setWhatHappensInCaseOfAlergies(response.residentsOfTheHouse().getWhatHappensInCaseOfAlergies());
    residentsOfTheHouse.setAllResidentsAgree(response.residentsOfTheHouse().isAllResidentsAgree());

    residentsOfTheHouse.setCandidate(candidate);
    return residentsOfTheHouse;
  }
}


