package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class EventResponseDto {
    long Id;
    String title;
    List<InsuranceCategory> damageType;
    String description;
    String payoutRange;
    EventStatus status;
    byte[] image;
    long insuranceId;

}

