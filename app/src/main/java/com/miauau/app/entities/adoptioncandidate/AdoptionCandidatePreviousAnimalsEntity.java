package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidatePreviousAnimals")
@Data
public class AdoptionCandidatePreviousAnimalsEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean ranAway;

    @Column(nullable = false)
    private boolean ranOver;

    @Column(nullable = false)
    private boolean diedOfOldAge;

    @Column(nullable = false)
    private boolean diedByAccident;

    @Column(nullable = false)
    private boolean disappeared;

    @Column(nullable = false)
    private boolean donatedToSomeone;

    @Column(nullable = false)
    private boolean stolen;

    @Column(nullable = false)
    private boolean diedFromIllness;

    @Column(nullable = false)
    private LocalDateTime dateOfOccurrence;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "adoption_candidate_other_animals_id")
    private AdoptionCandidateOtherAnimalsEntity otherAnimals;
}