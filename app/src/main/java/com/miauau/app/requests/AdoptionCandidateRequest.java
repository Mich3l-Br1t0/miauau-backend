package com.miauau.app.requests;

import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.entities.PersonEntity;

import java.util.List;

public record AdoptionCandidateRequest(
        PersonEntity person,
        boolean possibilityOfMoving,
        String whatHappensInCaseOfMoving,
        List<AnimalEntity> wantedAnimals
) {
}