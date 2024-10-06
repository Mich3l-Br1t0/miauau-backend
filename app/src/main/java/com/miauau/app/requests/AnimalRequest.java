package com.miauau.app.requests;

public record AnimalRequest(
    String name,
    Character sex,
    String description,
    Integer ageGroupId,
    Boolean castrated,
    Integer color,
    Integer approximatedAge,
    String vaccinationApplicationDate,
    String antiFleasApplicationDate,
    String dewormingApplicationDate,
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