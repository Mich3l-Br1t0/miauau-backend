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
@Table(name = "adoptionMotivation")
@Data
public class AdoptionMotivationEntity implements Serializable {
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

    @Column
    private String other;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "adoption_candidate_id")
    private AdoptionCandidateEntity candidate;
}