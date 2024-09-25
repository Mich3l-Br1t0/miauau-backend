package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateAnimalDailyCare")
@Data
public class AdoptionCandidateAnimalDailyCareEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String responsibleForCare;

    @Column(nullable = false)
    private String responsibleForCareInCaseOfTravel;

    @Column(nullable = false)
    private Integer dailyWalks;

    @Column(nullable = false)
    private String howWillEducate;

    @Column(nullable = false)
    private boolean hasPetCarrier;

    @OneToOne(mappedBy = "dailyCare", cascade = CascadeType.ALL)
    private AdoptionCandidateAnimalFoodTypeEntity foodType;

//    @OneToOne(mappedBy = "dailyCare", cascade = CascadeType.ALL)
//    private AdoptionCandidateAnimalDailyTimeAloneEntity timeAlone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}