package com.miauau.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "assistanceNeed")
@Table(name = "assistanceNeed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "animalId")
public class AssistanceNeedEntity {
    @Id
    private Long animalId;
    private boolean veterinarian;
    private boolean urgency;
    private boolean bath;
    private String other;
}
