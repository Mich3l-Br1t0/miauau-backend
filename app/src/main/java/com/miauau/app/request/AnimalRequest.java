package com.miauau.app.request;

public record AnimalRequest(
        String name,
        Character sex,
        String description,
        Long ageGroupId,
        boolean castrated,
        Integer color,
        Integer aproximatedAge
) {
}
