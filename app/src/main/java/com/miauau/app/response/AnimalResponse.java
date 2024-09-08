package com.miauau.app.response;

import com.miauau.app.entity.AnimalEntity;

public record AnimalResponse(
    Long id,
    String name,
    Character sex,
    String description,
    Long ageGroupId,
    boolean castrated,
    Integer color,
    Integer aproximatedAge,
    String createdAt
) {
    public AnimalResponse(AnimalEntity entity) {
        this(entity.getId(), entity.getName(), entity.getSex(), entity.getDescription(), entity.getAgeGroupId(), entity.isCastrated(), entity.getColor(), entity.getAproximatedAge(), entity.getCreatedAt());
    }
}