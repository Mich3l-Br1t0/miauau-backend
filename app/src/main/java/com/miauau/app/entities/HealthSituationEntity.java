package com.miauau.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "healthSituation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HealthSituationEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private boolean healthy = false;

  @Column(nullable = false)
  private boolean dirty = false;

  @Column(nullable = false)
  private boolean hurt = false;

  @Column(nullable = false)
  private boolean mange = false;

  @Column(nullable = false)
  private boolean fleas = false;

  @Column(nullable = false)
  private boolean ticks = false;

  @Column(nullable = false)
  private boolean vomiting = false;

  @Column(nullable = false)
  private boolean limping = false;

  @Column
  private String other;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToOne
  @JoinColumn(name = "animal_id")
  private AnimalEntity animal;
}
