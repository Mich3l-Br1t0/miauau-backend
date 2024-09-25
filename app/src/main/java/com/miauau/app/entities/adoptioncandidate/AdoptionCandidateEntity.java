package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miauau.app.entities.AnimalEntity;
import com.miauau.app.entities.PersonEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidate")
@Data
public class AdoptionCandidateEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @Column(nullable = false)
    private boolean possibilityOfMoving;

    @Column(nullable = false)
    private String whatHappensInCaseOfMoving;

//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateOtherAnimalsEntity otherAnimals;
//
//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateAgreementsEntity agreements;
//
//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateAnimalDailyCareEntity dailyCare;
//
//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateAttitudesTowardsTheAnimalEntity attitudesTowardsTheAnimal;
//
//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateHousingProfileEntity housingProfile;
//
//    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
//    private AdoptionCandidateHousingConditionsEntity housingConditions;
//
    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private AdoptionCandidateResidentsOfTheHouseEntity residentsOfTheHouse;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private AdoptionCandidateIncomeEntity income;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private AdoptionMotivationEntity motivation;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "candidate_wanted_animals",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private List<AnimalEntity> wantedAnimals;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}