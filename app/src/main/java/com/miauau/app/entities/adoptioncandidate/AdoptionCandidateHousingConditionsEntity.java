package com.miauau.app.entities.adoptioncandidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateHousingConditions")
@Data
public class AdoptionCandidateHousingConditionsEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean pool;

    @Column
    private Boolean poolWithProtection;

    @Column(nullable = false)
    private boolean fence;

    @Column(nullable = false)
    private boolean wall;

    @Column(nullable = false)
    private boolean windowsWithScreen;

    @Column(nullable = false)
    private boolean balconyWithScreen;

    @Column(nullable = false)
    private boolean willInstallScreens;

    @Column(nullable = false)
    private boolean yard;

    @Column
    private Boolean bigYard;

    @Column(nullable = false)
    private boolean safeHouse;

    @Column(nullable = false)
    private boolean flightRisk;

    @Column
    private String condominiumRestriction;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}