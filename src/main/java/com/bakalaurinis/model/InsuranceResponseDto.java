package com.bakalaurinis.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsuranceResponseDto {
    long id;
    String title;
    InsuranceStatus status;
    String category;
    String address;
    long userId;


}
