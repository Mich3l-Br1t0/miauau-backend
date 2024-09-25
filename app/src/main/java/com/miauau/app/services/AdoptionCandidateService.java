package com.miauau.app.services;

import com.miauau.app.entities.adoptioncandidate.*;
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

    AdoptionMotivationEntity motivation = getAdoptionMotivationEntity(response, candidate);
    candidate.setMotivation(motivation);

    AdoptionCandidateIncomeEntity income = getAdoptionCandidateIncomeEntity(response, candidate);
    candidate.setIncome(income);

    AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse = getAdoptionCandidateResidentsOfTheHouseEntity(response, candidate);
    candidate.setResidentsOfTheHouse(residentsOfTheHouse);

    AdoptionCandidateAgreementsEntity agreements = getAdoptionCandidateAgreementsEntity(response, candidate);
    candidate.setAgreements(agreements);

    return repository.save(candidate);
  }

  private static AdoptionMotivationEntity getAdoptionMotivationEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate){
    AdoptionMotivationEntity motivation = new AdoptionMotivationEntity();
    motivation.setCompany(response.motivation().isCompany());
    motivation.setGuardAndLook(response.motivation().isGuardAndLook());
    motivation.setGiftSomeone(response.motivation().isGiftSomeone());
    motivation.setOther(response.motivation().getOther());

    motivation.setCandidate(candidate);
    return motivation;
  }

  private static AdoptionCandidateIncomeEntity getAdoptionCandidateIncomeEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate){
    AdoptionCandidateIncomeEntity income = new AdoptionCandidateIncomeEntity();
    income.setFixed(response.income().isFixed());
    income.setVariable(response.income().isVariable());
    income.setDoesNotHave(response.income().isDoesNotHave());

    income.setCandidate(candidate);
    return income;
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

  private static AdoptionCandidateAgreementsEntity getAdoptionCandidateAgreementsEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate) {
    AdoptionCandidateAgreementsEntity agreements = new AdoptionCandidateAgreementsEntity();
    agreements.setCertaintyOfAdoption(response.agreements().isCertaintyOfAdoption());
    agreements.setAwareOfTheImportanceOfNeuteringTheAnimal(response.agreements().getAwareOfTheImportanceOfNeuteringTheAnimal());
    agreements.setAgreesWithCastration(response.agreements().isAgreesWithCastration());
    agreements.setLongTermCommitment(response.agreements().isLongTermCommitment());
    agreements.setImageUse(response.agreements().isImageUse());
    agreements.setMonetaryContribution(response.agreements().isMonetaryContribution());
    agreements.setHouseVisit(response.agreements().isHouseVisit());
    agreements.setNotifyBeforeDonateToSomeoneElse(response.agreements().isNotifyBeforeDonateToSomeoneElse());
    agreements.setTrueInformation(response.agreements().isTrueInformation());
    agreements.setVideoPresentation(response.agreements().isVideoPresentation());

    agreements.setCandidate(candidate);
    return agreements;
  }
}


