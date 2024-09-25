package com.miauau.app.requests;

public record AnimalRequest(
    String name,
    Character sex,
    String description,
    Integer ageGroupId,
    Boolean castrated,
    Integer color,
    Integer approximatedAge,
    String vaccination_application_date,
    String anti_fleas_application_date,
    String deworming_application_date
) {
}