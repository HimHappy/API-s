package com.example.crudoperation.service;

import com.example.crudoperation.module.EventModule;
import com.example.crudoperation.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class EventService {
    @Autowired
    private EventRepository eventrepository;

    public List<EventModule> get() {
        return eventrepository.findAll();
    }

    public Optional<EventModule> getOne(UUID id) {
       return eventrepository.findById(id);
    }

    public EventModule post(EventModule eventmodule) {
        return eventrepository.save(eventmodule);
    }

    public void deleteId(UUID id) {
       eventrepository.deleteById(id);
    }

    public EventModule put(EventModule eventModule) {
        Optional<EventModule> optionalEventModule=eventrepository.findById(eventModule.getEventId());
        AtomicReference<EventModule> eventModuleAtomicReference=new AtomicReference<>();
        optionalEventModule.ifPresentOrElse(ref-> {
            ref.setUpdatedTimeStamp(new Date());
            ref.setEventName(eventModule.getEventName()!=null?eventModule.getEventName(): ref.getEventName());
            ref.setEventDate(eventModule.getEventDate()!=null?eventModule.getEventDate():ref.getEventDate());
            ref.setEventDescription(eventModule.getEventDescription()!=null? eventModule.getEventDescription() : ref.getEventDescription());
            ref.setStatus(eventModule.getStatus()!=null?eventModule.getStatus():ref.getStatus());
            ref.setCity(eventModule.getCity()!=null?eventModule.getCity():ref.getCity());
            ref.setLocality(eventModule.getLocality()!=null?eventModule.getLocality():ref.getLocality());
            ref.setProperties(eventModule.getProperties()!=null?eventModule.getProperties():ref.getProperties());
            eventModuleAtomicReference.set(eventrepository.save(ref));
        },()->{
            try {
                throw new Exception("Event Not Found");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        return eventModuleAtomicReference.get();
    }
}
