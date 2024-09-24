package com.miauau.app.entities.adoption;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateHousingProfile")
@Data
public class AdoptionCandidateHousingProfileEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private boolean company;

    @Column(nullable = false)
    private boolean guardAndLook;

    @Column(nullable = false)
    private boolean giftSomeone;

    @Column(nullable = false)
    private boolean house;

    @Column(nullable = false)
    private boolean apartment;

    @Column(nullable = false)
    private boolean grange;

    @Column
    private String other;

    @Column(nullable = false)
    private boolean own;

    @Column(nullable = false)
    private boolean rented;

    @Column(nullable = false)
    private boolean inherited;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}
