package com.bakalaurinis.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class EventMapper {
    public static EventDto toeventDto(Event event){
        return EventDto.builder()
                .title(event.getTitle())
                .status(event.getStatus())
                .damageType(event.getDamageType())
                .description(event.getDescription())
                .payoutRange(event.getPayoutRange())
                .insuranceId(event.getInsurance().getId())
                .build();
    }
    public static EventDto2 toeventDto2(Event event){
        return EventDto2.builder()
                .title(event.getTitle())
                .status(event.getStatus())
                .damageType(event.getDamageType())
                .description(event.getDescription())
                .payoutRange(event.getPayoutRange())
                .insuranceId(event.getInsurance().getId())
                .build();
    }


    public static Event toevent(EventDto eventDto,Insurance insurance){
        return Event.builder()
                .title(eventDto.getTitle())
                .damageType(eventDto.getDamageType())
                .description(eventDto.getDescription())
                .payoutRange(eventDto.getPayoutRange())
                .insurance(insurance)
                .build();
    }

    public static Event toevent2(EventCreationDto eventDto, Insurance insurance, MultipartFile file) throws IOException {



        return Event.builder()
                .title(eventDto.getTitle())
                .damageType(eventDto.getDamageType())
                .description(eventDto.getDescription())
                .payoutRange(eventDto.getPayoutRange())
                .insurance(insurance)
                .image(file!=null? file.getBytes():null)
                .build();
    }

    public static EventResponseDto toEventResponseDto(Event event){
        return  EventResponseDto.builder()
                .Id(event.getId())
                .title(event.getTitle())
                .damageType(event.getDamageType())
                .description(event.getDescription())
                .payoutRange(event.getPayoutRange())
                .status(event.getStatus())
                .insuranceId(event.getInsurance().getId())
                .image(event.getImage())
                .build();

    }
    public static EventCreationDto toCreationDto(Event event){
        return  EventCreationDto.builder()
                .title(event.getTitle())
                .damageType(event.getDamageType())
                .description(event.getDescription())
                .payoutRange(event.getPayoutRange())
                .insuranceId(event.getInsurance().getId())
                .build();

    }

}
