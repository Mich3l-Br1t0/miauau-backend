package com.miauau.app.services;

import com.miauau.app.entities.adoptioncandidate.*;
import com.miauau.app.repositories.AdoptionCandidateRepository;
import com.miauau.app.requests.AdoptionCandidateRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
  public AdoptionCandidateEntity save(AdoptionCandidateRequest request) {
    AdoptionCandidateEntity candidate = new AdoptionCandidateEntity();
    candidate.setPerson(request.person());
    candidate.setPossibilityOfMoving(request.possibilityOfMoving());
    candidate.setWhatHappensInCaseOfMoving(request.whatHappensInCaseOfMoving());
    candidate.setWantedAnimals(request.wantedAnimals());

    AdoptionMotivationEntity motivation = getAdoptionMotivationEntity(request, candidate);
    candidate.setMotivation(motivation);

    AdoptionCandidateIncomeEntity income = getAdoptionCandidateIncomeEntity(request, candidate);
    candidate.setIncome(income);

    AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse = getAdoptionCandidateResidentsOfTheHouseEntity(request, candidate);
    candidate.setResidentsOfTheHouse(residentsOfTheHouse);

    AdoptionCandidateAgreementsEntity agreements = getAdoptionCandidateAgreementsEntity(request, candidate);
    candidate.setAgreements(agreements);

    AdoptionCandidateHousingConditionsEntity housingConditions = getAdoptionCandidateHousingConditionsEntity(request, candidate);
    candidate.setHousingConditions(housingConditions);

    AdoptionCandidateHousingProfileEntity housingProfile = getAdoptionCandidateHousingProfileEntity(request, candidate);
    candidate.setHousingProfile(housingProfile);

    AdoptionCandidateAttitudesTowardsTheAnimalEntity attitudesTowardsTheAnimal = getAdoptionCandidateAttitudesTowardsTheAnimalEntity(request, candidate);
    candidate.setAttitudesTowardsTheAnimal(attitudesTowardsTheAnimal);

    AdoptionCandidateOtherAnimalsEntity otherAnimals = getAdoptionCandidateOtherAnimalsEntity(request, candidate);
    candidate.setOtherAnimals(otherAnimals);

    AdoptionCandidateAnimalDailyCareEntity dailyCare = getAdoptionCandidateAnimalDailyCareEntity(request, candidate);
    candidate.setDailyCare(dailyCare);

    return repository.save(candidate);
  }

  private static AdoptionMotivationEntity getAdoptionMotivationEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate){
    AdoptionMotivationEntity motivation = new AdoptionMotivationEntity();
    motivation.setCompany(request.motivation().isCompany());
    motivation.setGuardAndLook(request.motivation().isGuardAndLook());
    motivation.setGiftSomeone(request.motivation().isGiftSomeone());
    motivation.setOther(request.motivation().getOther());

    motivation.setCandidate(candidate);
    return motivation;
  }

  private static AdoptionCandidateIncomeEntity getAdoptionCandidateIncomeEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate){
    AdoptionCandidateIncomeEntity income = new AdoptionCandidateIncomeEntity();
    income.setFixed(request.income().isFixed());
    income.setVariable(request.income().isVariable());
    income.setDoesNotHave(request.income().isDoesNotHave());

    income.setCandidate(candidate);
    return income;
  }

  private static AdoptionCandidateResidentsOfTheHouseEntity getAdoptionCandidateResidentsOfTheHouseEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse = new AdoptionCandidateResidentsOfTheHouseEntity();
    residentsOfTheHouse.setLivesAlone(request.residentsOfTheHouse().isLivesAlone());
    residentsOfTheHouse.setAmountOfChildrenInTheHouse(request.residentsOfTheHouse().getAmountOfChildrenInTheHouse());
    residentsOfTheHouse.setChildrensAges(request.residentsOfTheHouse().getChildrensAges());
    residentsOfTheHouse.setAlergicResidents(request.residentsOfTheHouse().isAlergicResidents());
    residentsOfTheHouse.setWhatHappensInCaseOfAlergies(request.residentsOfTheHouse().getWhatHappensInCaseOfAlergies());
    residentsOfTheHouse.setAllResidentsAgree(request.residentsOfTheHouse().isAllResidentsAgree());

    residentsOfTheHouse.setCandidate(candidate);
    return residentsOfTheHouse;
  }

  private static AdoptionCandidateAgreementsEntity getAdoptionCandidateAgreementsEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateAgreementsEntity agreements = new AdoptionCandidateAgreementsEntity();
    agreements.setCertaintyOfAdoption(request.agreements().isCertaintyOfAdoption());
    agreements.setAwareOfTheImportanceOfNeuteringTheAnimal(request.agreements().getAwareOfTheImportanceOfNeuteringTheAnimal());
    agreements.setAgreesWithCastration(request.agreements().isAgreesWithCastration());
    agreements.setLongTermCommitment(request.agreements().isLongTermCommitment());
    agreements.setImageUse(request.agreements().isImageUse());
    agreements.setMonetaryContribution(request.agreements().isMonetaryContribution());
    agreements.setHouseVisit(request.agreements().isHouseVisit());
    agreements.setNotifyBeforeDonateToSomeoneElse(request.agreements().isNotifyBeforeDonateToSomeoneElse());
    agreements.setTrueInformation(request.agreements().isTrueInformation());
    agreements.setVideoPresentation(request.agreements().isVideoPresentation());

    agreements.setCandidate(candidate);
    return agreements;
  }

  private static AdoptionCandidateHousingConditionsEntity getAdoptionCandidateHousingConditionsEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate){
    AdoptionCandidateHousingConditionsEntity housingConditions = new AdoptionCandidateHousingConditionsEntity();
    housingConditions.setPool(request.housingConditions().isPool());
    housingConditions.setPoolWithProtection(request.housingConditions().getPoolWithProtection());
    housingConditions.setFence(request.housingConditions().isFence());
    housingConditions.setWall(request.housingConditions().isWall());
    housingConditions.setWindowsWithScreen(request.housingConditions().isWindowsWithScreen());
    housingConditions.setBalconyWithScreen(request.housingConditions().isBalconyWithScreen());
    housingConditions.setWillInstallScreens(request.housingConditions().isWillInstallScreens());
    housingConditions.setYard(request.housingConditions().isYard());
    housingConditions.setBigYard(request.housingConditions().getBigYard());
    housingConditions.setSafeHouse(request.housingConditions().isSafeHouse());
    housingConditions.setCondominiumRestriction(request.housingConditions().getCondominiumRestriction());

    housingConditions.setCandidate(candidate);
    return housingConditions;
  }

  private static AdoptionCandidateHousingProfileEntity getAdoptionCandidateHousingProfileEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateHousingProfileEntity housingProfile = new AdoptionCandidateHousingProfileEntity();
    housingProfile.setHouse(request.housingProfile().isHouse());
    housingProfile.setApartment(request.housingProfile().isApartment());
    housingProfile.setGrange(request.housingProfile().isGrange());
    housingProfile.setOther(request.housingProfile().getOther());
    housingProfile.setOwn(request.housingProfile().isOwn());
    housingProfile.setRented(request.housingProfile().isRented());
    housingProfile.setInherited(request.housingProfile().isInherited());
    housingProfile.setCandidate(candidate);

    return housingProfile;
  }

  private static AdoptionCandidateAttitudesTowardsTheAnimalEntity getAdoptionCandidateAttitudesTowardsTheAnimalEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateAttitudesTowardsTheAnimalEntity attitudesTowardsTheAnimal = new AdoptionCandidateAttitudesTowardsTheAnimalEntity();
    attitudesTowardsTheAnimal.setGetsLost(request.attitudesTowardsTheAnimal().getGetsLost());
    attitudesTowardsTheAnimal.setGetsSickOrAccident(request.attitudesTowardsTheAnimal().getGetsSickOrAccident());
    attitudesTowardsTheAnimal.setHurtsYourChild(request.attitudesTowardsTheAnimal().getHurtsYourChild());
    attitudesTowardsTheAnimal.setDamagesValuableObject(request.attitudesTowardsTheAnimal().getDamagesValuableObject());
    attitudesTowardsTheAnimal.setPeesOrPoopsInInappropriatePlace(request.attitudesTowardsTheAnimal().getPeesOrPoopsInInappropriatePlace());
    attitudesTowardsTheAnimal.setDoesThingsYouDontWant(request.attitudesTowardsTheAnimal().getDoesThingsYouDontWant());
    attitudesTowardsTheAnimal.setIfYouHaveAChild(request.attitudesTowardsTheAnimal().getIfYouHaveAChild());
    attitudesTowardsTheAnimal.setCandidate(candidate);

    return attitudesTowardsTheAnimal;
  }

  private static AdoptionCandidateOtherAnimalsEntity getAdoptionCandidateOtherAnimalsEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateOtherAnimalsEntity otherAnimals = new AdoptionCandidateOtherAnimalsEntity();
    otherAnimals.setNumberOfAnimalsCurrently(request.otherAnimals().getNumberOfAnimalsCurrently());
    otherAnimals.setCastrated(request.otherAnimals().isCastrated());
    otherAnimals.setCastratedObservation(request.otherAnimals().getCastratedObservation());
    otherAnimals.setHadAnimalsBefore(request.otherAnimals().isHadAnimalsBefore());
    otherAnimals.setPreviousAnimals(getPreviousAnimals(request, otherAnimals));

    return otherAnimals;
  }

  private static List<AdoptionCandidatePreviousAnimalsEntity> getPreviousAnimals(AdoptionCandidateRequest request, AdoptionCandidateOtherAnimalsEntity other){
    List<AdoptionCandidatePreviousAnimalsEntity> previousAnimals = new ArrayList<AdoptionCandidatePreviousAnimalsEntity>();
    request.otherAnimals().getPreviousAnimals().forEach((AdoptionCandidatePreviousAnimalsEntity animalRequest) -> {
      AdoptionCandidatePreviousAnimalsEntity animal = new AdoptionCandidatePreviousAnimalsEntity();
      animal.setRanAway(animalRequest.isRanAway());
      animal.setRanOver(animalRequest.isRanOver());
      animal.setDiedOfOldAge(animalRequest.isDiedOfOldAge());
      animal.setDiedByAccident(animalRequest.isDiedByAccident());
      animal.setDisappeared(animalRequest.isDisappeared());
      animal.setDonatedToSomeone(animalRequest.isDonatedToSomeone());
      animal.setStolen(animalRequest.isStolen());
      animal.setDiedFromIllness(animalRequest.isDiedFromIllness());
      animal.setDateOfOccurrence(animalRequest.getDateOfOccurrence());
      animal.setOtherAnimals(other);
      previousAnimals.add(animal);
    });
    return  previousAnimals;
  }

  private static AdoptionCandidateAnimalDailyCareEntity getAdoptionCandidateAnimalDailyCareEntity(AdoptionCandidateRequest request, AdoptionCandidateEntity candidate) {
    AdoptionCandidateAnimalDailyCareEntity dailyCare = new AdoptionCandidateAnimalDailyCareEntity();
    dailyCare.setResponsibleForCare(request.dailyCare().getResponsibleForCare());
    dailyCare.setResponsibleForCareInCaseOfTravel(request.dailyCare().getResponsibleForCareInCaseOfTravel());
    dailyCare.setDailyWalks(request.dailyCare().getDailyWalks());
    dailyCare.setHowWillEducate(request.dailyCare().getHowWillEducate());
    dailyCare.setHasPetCarrier(request.dailyCare().isHasPetCarrier());

    return dailyCare;
  }
}


