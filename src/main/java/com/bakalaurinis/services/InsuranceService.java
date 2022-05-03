package com.bakalaurinis.services;

import com.bakalaurinis.model.*;
import com.bakalaurinis.repository.EventRepository;
import com.bakalaurinis.repository.InsuranceRepository;
import com.bakalaurinis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    @Autowired
    private final InsuranceRepository insuranceRepository;
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final EventRepository eventRepository;


    public List<InsuranceDtoWithEvents> getInsuranceByUser(Long id){
        System.out.println("atejome, user id: " + id);
//        List<InsuranceDtoWithEvents> insuranceDtoWithEventsList =
        return insuranceRepository.
                findAllByUser(userService.getUser(id))
                .stream()
                .map(InsuranceMapper::insuranceDtoWithEvents)
                .collect(Collectors.toList());
    }
    public Optional<InsuranceDto> getInsuranceDto(Long id){
        return insuranceRepository.findById(id).map(InsuranceMapper::toInsuranceDto);
    }
    public Optional<InsuranceDtoWithEvents> getinsurancewithevents(Long id){
        return insuranceRepository.findById(id).map(InsuranceMapper::insuranceDtoWithEvents);
    }

    public InsuranceResponseDto create(InsuranceDto insuranceDto){
        return saveinsurance(insuranceDto);
    }
    public Insurance getInsurance(Long id){
        Optional<Insurance> insurance = insuranceRepository.findById(id);
        return insurance.get();
    }


    private InsuranceResponseDto saveinsurance(InsuranceDto insuranceDto){
        System.out.println(insuranceDto.getUserId());
        User user = userService.getUser(insuranceDto.getUserId());
        Insurance savedinsurance = InsuranceMapper.toInsurance(insuranceDto,user);
        insuranceRepository.save(savedinsurance);
        return InsuranceMapper.toResponseDto(savedinsurance);

    }



//    public InsuranceDto getUserInsurance(Long id){
//        Optional<InsuranceDto> insurance = insuranceRepository.findById(id);
//        return insurance.get();
//    }


}
