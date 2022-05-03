package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InsuranceDto {

    String title;
    InsuranceStatus status;
    String category;
    String address;
    long userId;

}
