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

    AdoptionCandidateHousingConditionsEntity housingConditions = getAdoptionCandidateHousingConditionsEntity(response, candidate);
    candidate.setHousingConditions(housingConditions);

    AdoptionCandidateHousingProfileEntity housingProfile = getAdoptionCandidateHousingProfileEntity(response, candidate);
    candidate.setHousingProfile(housingProfile);

    AdoptionCandidateAttitudesTowardsTheAnimalEntity attitudesTowardsTheAnimal = getAdoptionCandidateAttitudesTowardsTheAnimalEntity(response, candidate);
    candidate.setAttitudesTowardsTheAnimal(attitudesTowardsTheAnimal);

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

  private static AdoptionCandidateHousingConditionsEntity getAdoptionCandidateHousingConditionsEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate){
    AdoptionCandidateHousingConditionsEntity housingConditions = new AdoptionCandidateHousingConditionsEntity();
    housingConditions.setPool(response.housingConditions().isPool());
    housingConditions.setPoolWithProtection(response.housingConditions().getPoolWithProtection());
    housingConditions.setFence(response.housingConditions().isFence());
    housingConditions.setWall(response.housingConditions().isWall());
    housingConditions.setWindowsWithScreen(response.housingConditions().isWindowsWithScreen());
    housingConditions.setBalconyWithScreen(response.housingConditions().isBalconyWithScreen());
    housingConditions.setWillInstallScreens(response.housingConditions().isWillInstallScreens());
    housingConditions.setYard(response.housingConditions().isYard());
    housingConditions.setBigYard(response.housingConditions().getBigYard());
    housingConditions.setSafeHouse(response.housingConditions().isSafeHouse());
    housingConditions.setCondominiumRestriction(response.housingConditions().getCondominiumRestriction());

    housingConditions.setCandidate(candidate);
    return housingConditions;
  }

  private static AdoptionCandidateHousingProfileEntity getAdoptionCandidateHousingProfileEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate) {
    AdoptionCandidateHousingProfileEntity housingProfile = new AdoptionCandidateHousingProfileEntity();
    housingProfile.setHouse(response.housingProfile().isHouse());
    housingProfile.setApartment(response.housingProfile().isApartment());
    housingProfile.setGrange(response.housingProfile().isGrange());
    housingProfile.setOther(response.housingProfile().getOther());
    housingProfile.setOwn(response.housingProfile().isOwn());
    housingProfile.setRented(response.housingProfile().isRented());
    housingProfile.setInherited(response.housingProfile().isInherited());
    housingProfile.setCandidate(candidate);

    return housingProfile;
  }

  private AdoptionCandidateAttitudesTowardsTheAnimalEntity getAdoptionCandidateAttitudesTowardsTheAnimalEntity(AdoptionCandidateRequest response, AdoptionCandidateEntity candidate) {
    AdoptionCandidateAttitudesTowardsTheAnimalEntity attitudesTowardsTheAnimal = new AdoptionCandidateAttitudesTowardsTheAnimalEntity();
    attitudesTowardsTheAnimal.setGetsLost(response.attitudesTowardsTheAnimal().getGetsLost());
    attitudesTowardsTheAnimal.setGetsSickOrAccident(response.attitudesTowardsTheAnimal().getGetsSickOrAccident());
    attitudesTowardsTheAnimal.setHurtsYourChild(response.attitudesTowardsTheAnimal().getHurtsYourChild());
    attitudesTowardsTheAnimal.setDamagesValuableObject(response.attitudesTowardsTheAnimal().getDamagesValuableObject());
    attitudesTowardsTheAnimal.setPeesOrPoopsInInappropriatePlace(response.attitudesTowardsTheAnimal().getPeesOrPoopsInInappropriatePlace());
    attitudesTowardsTheAnimal.setDoesThingsYouDontWant(response.attitudesTowardsTheAnimal().getDoesThingsYouDontWant());
    attitudesTowardsTheAnimal.setIfYouHaveAChild(response.attitudesTowardsTheAnimal().getIfYouHaveAChild());
    attitudesTowardsTheAnimal.setCandidate(candidate);

    return attitudesTowardsTheAnimal;
  }
}


