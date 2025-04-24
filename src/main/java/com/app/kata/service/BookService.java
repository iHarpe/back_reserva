package com.app.kata.service;

import com.app.kata.entity.Bookings;
import com.app.kata.entity.Events;
import com.app.kata.repository.BookingsRepo;
import com.app.kata.repository.EventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookingsRepo bookingsRepo;

    @Autowired
    private EventService eventService;

    public Bookings createBooking(Bookings booking){
        Events event = eventService.getEvent(booking.getEVENTORSV());
        if (event.getASISTENTESTOT() >= event.getASISTENTESMAX()){
            throw new IllegalStateException("El evento está completo");
        }
        event.setASISTENTESTOT(event.getASISTENTESTOT() + 1);
        eventService.updateEvent(event);
        return bookingsRepo.save(booking);
    }

    public Bookings getBooking(BigInteger id){
        return bookingsRepo.getReferenceById(id);
    }

    public List<Bookings> getAllBookings(){
        return bookingsRepo.findAll();
    }

    public Bookings updateBooking(BigInteger id, Bookings boNew){
        Bookings existingBook = bookingsRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingBook.setEVENTORSV(boNew.getEVENTORSV());
        existingBook.setFECHARESERVA(boNew.getFECHARESERVA());
        bookingsRepo.save(existingBook);
        return existingBook;
    }

    public Bookings deleteBooking(BigInteger id){
        Bookings existingBook = bookingsRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        Events event = eventService.getEvent(existingBook.getEVENTORSV());
        if (event.getASISTENTESTOT() > 0){
            event.setASISTENTESTOT(event.getASISTENTESTOT()-1);
            eventService.updateEvent(event);
        }

        bookingsRepo.deleteById(id);
        return existingBook;
    }
}
