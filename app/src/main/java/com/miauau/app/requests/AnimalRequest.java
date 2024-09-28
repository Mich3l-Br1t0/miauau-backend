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
    String deworming_application_date,
    //  Assistance Need Info
    Boolean veterinarian,
    Boolean urgency,
    Boolean bath,
    String otherAssistanceNeedInfo,
    //  Health Situation Info
    Boolean healthy,
    Boolean dirty,
    Boolean hurt,
    Boolean mange,
    Boolean fleas,
    Boolean ticks,
    Boolean vomiting,
    Boolean limping,
    String otherHealthSituation
) {
}