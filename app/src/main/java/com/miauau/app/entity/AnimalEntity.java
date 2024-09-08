package com.miauau.app.entity;

import com.miauau.app.response.AnimalResponse;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@jakarta.persistence.Entity(name = "animal")
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnimalEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Character sex;
    private String description;
    private Long ageGroupId;
    private boolean castrated;
    private Integer color;
    private Integer aproximatedAge;
    private String createdAt;

    public AnimalEntity(AnimalResponse response) {
        this.name = response.name();
        this.sex = response.sex();
        this.description = response.description();
        this.ageGroupId = response.ageGroupId();
        this.castrated = response.castrated();
        this.color = response.color();
        this.aproximatedAge = response.aproximatedAge();
        this.createdAt = LocalDateTime.now().toString();
    }
}
