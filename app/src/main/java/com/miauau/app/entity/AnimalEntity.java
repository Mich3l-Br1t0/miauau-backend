package com.miauau.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "animal")
@Data
public class AnimalEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private Character sex;

  @Column
  private String description;

  @Column(nullable = false)
  private Integer ageGroupId;

  @Column(nullable = false)
  private Boolean castrated;

  @Column(nullable = false)
  private Integer color;

  @Column(nullable = false)
  private Integer approximatedAge;

  @Column
  private String vaccination_application_date;

  @Column
  private String anti_fleas_application_date;

  @Column
  private String deworming_application_date;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
  private AssistanceNeedEntity assistanceNeed;

  @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
  private HealthSituationEntity healthSituation;

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }
}
