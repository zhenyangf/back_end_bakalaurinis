package com.bakalaurinis.services;

import com.bakalaurinis.model.*;
import com.bakalaurinis.repository.EventRepository;
import com.bakalaurinis.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.mortbay.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService{
    @Autowired
    InsuranceService insuranceService;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    InsuranceRepository insuranceRepository;


    public EventResponseDto saveEvent(EventCreationDto eventDto,MultipartFile file) throws IOException {

        Insurance insurance =insuranceService.getInsurance(eventDto.getInsuranceId());
        Event event = EventMapper.toevent2(eventDto,insurance,file);
        eventRepository.save(event);
        return EventMapper.toEventResponseDto(event);
    }
    public Optional<EventDto> getEventDto(Long id){
        return eventRepository.findById(id).map(EventMapper::toeventDto);
    }

    public List<EventResponseDto> getEvenyByInsuranceId(Long id){

        return eventRepository.
                findAllByInsurance(insuranceService.getInsurance(id))
                .stream()
                .map(EventMapper::toEventResponseDto)
                .collect(Collectors.toList());
    }


}
