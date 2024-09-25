package com.miauau.app.entities;

//import com.miauau.app.entities.adoption.AdoptionCandidateEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "person")
@Data
public class PersonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateOfBirth;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String cpf;

//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    private Long addressId;

    @Column(nullable = false)
    private String phone;

    @Column
    private String landline;

    @Column(nullable = false)
    private String email;

//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    private Long occupationId;

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false)
    private LocalDateTime createdAt;

//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    private AdoptionCandidateEntity candidate;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}