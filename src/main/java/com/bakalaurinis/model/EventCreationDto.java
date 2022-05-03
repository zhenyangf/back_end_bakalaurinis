package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EventCreationDto {
    String title;
    List<InsuranceCategory> damageType;
    String description;
    String payoutRange;
    long insuranceId;


}
