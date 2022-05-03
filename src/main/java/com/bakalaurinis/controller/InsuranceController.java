package com.bakalaurinis.controller;

import com.bakalaurinis.model.Event;
import com.bakalaurinis.model.InsuranceDto;
import com.bakalaurinis.model.InsuranceDtoWithEvents;
import com.bakalaurinis.model.InsuranceResponseDto;
import com.bakalaurinis.repository.EventRepository;
import com.bakalaurinis.repository.InsuranceRepository;
import com.bakalaurinis.services.InsuranceService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InsuranceController {
    @Autowired
    InsuranceRepository insuranceRepository;
    @Autowired
    InsuranceService insuranceService;
    @Autowired
    EventRepository eventRepository;
    @PostMapping("/user/insurance/add")
    public InsuranceResponseDto addnewinsurance(@RequestBody InsuranceDto insurance){
        return insuranceService.create(insurance);
    }

    @GetMapping("user/{id}/insurance")
    public List<InsuranceDtoWithEvents> getInsuranceByUserId(@PathVariable Long id,HttpServletResponse response, HttpServletRequest request){

        return insuranceService.getInsuranceByUser(id);
    }
    @GetMapping("user/insurance/{id}")
    public Optional<InsuranceDtoWithEvents> getInsurance(@PathVariable Long id){
        return insuranceService.getinsurancewithevents(id);
    }





}
