package com.example.crudoperation.controller;

import com.example.crudoperation.module.EventModule;
import com.example.crudoperation.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Event")
public class EventController {
    @Autowired
    private EventService eventservice;

    @GetMapping(path = "/All",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EventModule> getAllEvent(){
        return eventservice.get();
    }

    @GetMapping(path = "/{EventId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EventModule> get(@PathVariable("EventId") UUID EventId){
        return eventservice.getOne(EventId);
    }

    @PostMapping(path = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public Object posting(@RequestBody EventModule eventmodule){
        return eventservice.post(eventmodule);
    }

    @DeleteMapping(path = "/delete/{EventId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("EventId") UUID EventId){
        eventservice.deleteId(EventId);
    }

    @PutMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public EventModule putting(@RequestBody EventModule eventModule){
       return eventservice.put(eventModule);
    }
}
