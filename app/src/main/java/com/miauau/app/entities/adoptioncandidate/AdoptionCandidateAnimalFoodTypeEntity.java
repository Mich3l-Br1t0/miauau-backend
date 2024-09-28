package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateAnimalFoodType")
@Data
public class AdoptionCandidateAnimalFoodTypeEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean animalFood;

    @Column(nullable = false)
    private boolean humanFood;

    @Column
    private String other;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_animal_daily_care_id")
    private AdoptionCandidateAnimalDailyCareEntity dailyCare;
}