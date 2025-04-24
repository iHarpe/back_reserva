package com.app.kata.controller;

import com.app.kata.entity.Bookings;
import com.app.kata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookControl {

    @Autowired
    private BookService bookService;

    @PostMapping("/createBooking")
    public ResponseEntity<?> createBooking(@RequestBody Bookings booking) {
        try {
            Bookings newBooking = bookService.createBooking(booking);
            return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getBooking")
    public ResponseEntity<Bookings> getBooking(@RequestParam(name = "id") BigInteger id) {
        Bookings booking = bookService.getBooking(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Bookings>> getBooking() {
        List<Bookings> allBookings = bookService.getAllBookings();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @PatchMapping("/updateBooking")
    public ResponseEntity<Bookings> updateBooking(@RequestBody Bookings booking) {
        Bookings updBooking = bookService.updateBooking(booking.getIDBOOKING(), booking);
        return new ResponseEntity<>(updBooking, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Bookings> deleteBooking(@RequestParam(name = "id") BigInteger id) {
        Bookings delBooking = bookService.deleteBooking(id);
        return new ResponseEntity<>(delBooking, HttpStatus.OK);
    }


}
