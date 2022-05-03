package com.bakalaurinis.model;

import com.bakalaurinis.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InsuranceMapper {


    public static InsuranceDto toInsuranceDto(Insurance insurance){
        return InsuranceDto.builder()
                .title(insurance.getTitle())
                .status(insurance.getStatus())
                .category(insurance.getCategory())
                .address(insurance.getAddress())
                .userId(insurance.getUser().getId())
                .build();
    }
    public static InsuranceDtoWithEvents insuranceDtoWithEvents(Insurance insurance){

        return InsuranceDtoWithEvents.builder()
                .title(insurance.getTitle())
                .category(insurance.getCategory())
                .address(insurance.getAddress())
                .events(insurance.getEvents().stream().map(EventMapper::toeventDto2).collect(Collectors.toList()))
                .status(insurance.getStatus())
                .userId(insurance.getUser().getId())
                .id(insurance.getId())
                .build();
    }
    public static Insurance toInsurance(InsuranceDto insuranceDto, User user){
        return Insurance.builder()
                .title(insuranceDto.getTitle())
                .status(insuranceDto.getStatus())
                .category(insuranceDto.getCategory())
                .address(insuranceDto.getAddress())
                .user(user)
                .build();

    }

    public static InsuranceResponseDto toResponseDto(Insurance insurance){
        return  InsuranceResponseDto.builder()
                .id(insurance.getId())
                .title(insurance.getTitle())
                .status(insurance.getStatus())
                .category(insurance.getCategory())
                .address(insurance.getAddress())
                .userId(insurance.getUser().getId())
                .build();

    }

}
