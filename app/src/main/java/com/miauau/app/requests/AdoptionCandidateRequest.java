package com.miauau.app.requests;

import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.entities.PersonEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateAgreementsEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateIncomeEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateResidentsOfTheHouseEntity;
import com.miauau.app.entities.adoptioncandidate.AdoptionMotivationEntity;

import java.util.List;

public record AdoptionCandidateRequest(
        PersonEntity person,
        boolean possibilityOfMoving,
        String whatHappensInCaseOfMoving,
        List<AnimalEntity> wantedAnimals,
        AdoptionMotivationEntity motivation,
        AdoptionCandidateIncomeEntity income,
        AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse,
        AdoptionCandidateAgreementsEntity agreements
) {
}