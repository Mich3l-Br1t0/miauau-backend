package com.miauau.app.entities;

import com.miauau.app.entities.adoptioncandidate.AdoptionCandidateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
  private String vaccinationApplicationDate;

  @Column
  private String antiFleasApplicationDate;

  @Column
  private String dewormingApplicationDate;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @Column
  private String imageName;

  @Column
  private String imageType;

  @Column
  @Lob
  private byte[] image;

  @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
  private AssistanceNeedEntity assistanceNeed;

  @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
  private HealthSituationEntity healthSituation;

  @ManyToMany(mappedBy = "wantedAnimals")
  private List<AdoptionCandidateEntity> adoptionCandidates;

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }
}
