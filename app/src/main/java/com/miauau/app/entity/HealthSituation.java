package com.miauau.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "healthSituation")
@Table(name = "healthSituation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "animalId")
public class HealthSituation {
    private Long animalId;
    private boolean healthy;
    private boolean dirty;
    private boolean hurt;
    private boolean mange;
    private boolean fleas;
    private boolean ticks;
    private boolean vomiting;
    private boolean limping;
    private String other;
}
