package com.app.kata.controller;

import com.app.kata.entity.Events;
import com.app.kata.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EventControl {

    @Autowired
    EventService eventService;

    @PostMapping("/createEvent")
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        Events newBooking = eventService.createEvent(event);
        if (newBooking.equals(null)){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping("/getEvent")
    public ResponseEntity<Events> getEvent(@RequestParam(name = "id") BigInteger id) {
        Events booking = eventService.getEvent(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/getAllEvents")
    public ResponseEntity<List<Events>> getAllEvents() {
        List<Events> allBookings = eventService.getAllEvents();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @PatchMapping("/updateEvents")
    public ResponseEntity<Events> eventService(@RequestBody Events event) {
        Events updBooking = eventService.updateEvent(event);
        return new ResponseEntity<>(updBooking, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEvents")
    public ResponseEntity<Events> deleteEvents(@RequestParam(name = "id") BigInteger id) {
        Events delBooking = eventService.deleteEvent(id);
        return new ResponseEntity<>(delBooking, HttpStatus.OK);
    }
}
