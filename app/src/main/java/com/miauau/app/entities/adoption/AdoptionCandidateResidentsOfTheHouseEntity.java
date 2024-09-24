package com.miauau.app.entities.adoption;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateResidentsOfTheHouse")
@Data
public class AdoptionCandidateResidentsOfTheHouseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean livesAlone;

    @Column
    private String livesWithWho;

    @Column(nullable = false)
    private Integer amountOfChildrenInTheHouse;

    @Column
    private String childrensAges;

    @Column(nullable = false)
    private boolean alergicResidents;

    @Column
    private String whatHappensInCaseOfAlergies;

    @Column(nullable = false)
    private boolean allResidentsAgree;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}
