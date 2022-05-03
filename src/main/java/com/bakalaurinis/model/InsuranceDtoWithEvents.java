package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InsuranceDtoWithEvents {
        String title;
        String category;
        String address;
        InsuranceStatus status;
        long userId;
        List<EventDto2> events;
        long id;

}
