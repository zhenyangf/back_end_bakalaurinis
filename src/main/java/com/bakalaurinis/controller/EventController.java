package com.bakalaurinis.controller;

import com.bakalaurinis.model.*;
import com.bakalaurinis.repository.EventRepository;
import com.bakalaurinis.services.EventService;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/insurance")
public class EventController {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    EventService eventService;

    @PostMapping("/event/add")
    public EventResponseDto addnewevent(EventCreationDto eventDto, @RequestParam(name="file", required=false) MultipartFile file) throws IOException {
        return eventService.saveEvent(eventDto,file);
    }
    @GetMapping ("/image/{id}")
    public @ResponseBody byte[] eventImage(@PathVariable Long id) throws UnsupportedEncodingException {
         Event event = eventRepository.getById(id);
         return event.getImage();
    }
    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") long id, HttpServletResponse response,HttpServletRequest request)
            throws ServletException, IOException {

        Event event = eventRepository.getById(id);
        response.setContentType("image/jpg");
        response.getOutputStream().write(event.getImage());

        response.getOutputStream().close();

    }

//
//    @GetMapping("/event/{id}")
//    public Optional<EventDto>  getEvent(@PathVariable Long id){
//        return eventService.getEventDto(id);
//    }
//    @GetMapping("/{id}/event")
//    public List<EventResponseDto> getEventByInsuranceId(@PathVariable Long id){
//        return eventService.getEvenyByInsuranceId(id);
//    }



}
