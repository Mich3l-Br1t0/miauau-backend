package com.miauau.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "assistanceNeed")
@Data
public class AssistanceNeedEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private boolean veterinarian;

  @Column(nullable = false)
  private boolean urgency;

  @Column(nullable = false)
  private boolean bath;

  @Column
  private String other;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne
  @JoinColumn(name = "animal_id")
  private AnimalEntity animal;
}
