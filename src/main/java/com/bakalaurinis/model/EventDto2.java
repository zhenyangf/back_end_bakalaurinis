package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder

public class EventDto2 {
    long id;
    String title;
    List<InsuranceCategory> damageType;
    String description;
    String payoutRange;
    EventStatus status;
    long insuranceId;


}
