package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateOtherAnimals")
@Data
public class AdoptionCandidateOtherAnimalsEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Integer numberOfAnimalsCurrently;

    @Column
    private boolean castrated;

    @Column
    private String castratedObservation;

    @Column(nullable = false)
    private boolean hadAnimalsBefore;

    @OneToMany(mappedBy = "otherAnimals", cascade = CascadeType.ALL)
    private List<AdoptionCandidatePreviousAnimalsEntity> previousAnimals;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}