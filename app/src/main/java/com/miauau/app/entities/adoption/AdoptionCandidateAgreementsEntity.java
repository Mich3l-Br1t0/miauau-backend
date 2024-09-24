package com.miauau.app.entities.adoption;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateAgreements")
@Data
public class AdoptionCandidateAgreementsEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean certaintyOfAdoption;

    @Column(nullable = false)
    private String awareOfTheImportanceOfNeuteringTheAnimal;

    @Column(nullable = false)
    private boolean agreesWithCastration;

    @Column(nullable = false)
    private boolean longTermCommitment;

    @Column(nullable = false)
    private boolean imageUse;

    @Column(nullable = false)
    private boolean monetaryContribution;

    @Column(nullable = false)
    private boolean houseVisit;

    @Column(nullable = false)
    private boolean notifyBeforeDonateToSomeoneElse;

    @Column(nullable = false)
    private boolean trueInformation;

    @Column(nullable = false)
    private boolean videoPresentation;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}
