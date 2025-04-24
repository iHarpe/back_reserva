package com.app.kata.service;

import com.app.kata.entity.Events;
import com.app.kata.repository.EventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class EventService {
    @Autowired
    EventsRepo eventsRepo;

    public Events createEvent(Events event){
        return eventsRepo.save(event);
    }

    public Events getEvent(BigInteger id){
        return eventsRepo.getReferenceById(id);
    }

    public List<Events> getAllEvents(){
        return eventsRepo.findAll();
    }

    public Events updateEvent(Events event){
        Events existingEvent = eventsRepo.findById(event.getIDEVENT()).orElseThrow(() -> new RuntimeException("Not Found"));
        existingEvent.setASISTENTESMAX(event.getASISTENTESMAX());
        existingEvent.setASISTENTESTOT(event.getASISTENTESTOT());
        existingEvent.setDESCRIPCION(event.getDESCRIPCION());
        existingEvent.setFECHAEVENTO(event.getFECHAEVENTO());
        existingEvent.setNOMBRE(event.getNOMBRE());
        eventsRepo.save(existingEvent);
        return existingEvent;
    }

    public Events deleteEvent(BigInteger id){
        Events existingEvent = eventsRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        eventsRepo.deleteById(id);
        return existingEvent;
    }

}
