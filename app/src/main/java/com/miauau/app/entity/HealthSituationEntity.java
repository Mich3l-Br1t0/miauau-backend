package com.miauau.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "healthSituation")
@Data
public class HealthSituationEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private boolean healthy;

  @Column(nullable = false)
  private boolean dirty;

  @Column(nullable = false)
  private boolean hurt;

  @Column(nullable = false)
  private boolean mange;

  @Column(nullable = false)
  private boolean fleas;

  @Column(nullable = false)
  private boolean ticks;

  @Column(nullable = false)
  private boolean vomiting;

  @Column(nullable = false)
  private boolean limping;

  @Column
  private String other;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne
  @JoinColumn(name = "animal_id")
  private AnimalEntity animal;
}
