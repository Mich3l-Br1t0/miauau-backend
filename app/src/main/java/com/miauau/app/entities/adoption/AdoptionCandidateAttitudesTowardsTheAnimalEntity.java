package com.miauau.app.entities.adoption;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "adoptionCandidateAttitudesTowardsTheAnimal")
@Data
public class AdoptionCandidateAttitudesTowardsTheAnimalEntity implements Serializable {
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
    private String getsLost;

    @Column(nullable = false)
    private String getsSickOrAccident;

    @Column(nullable = false)
    private String hurtsYourChild;

    @Column(nullable = false)
    private String damagesValuableObject;

    @Column(nullable = false)
    private String peesOrPoopsInInappropriatePlace;

    @Column(nullable = false)
    private String doesThingsYouDontWant;

    @Column(nullable = false)
    private String ifYouHaveAChild;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}
