package com.app.kata.repository;

import com.app.kata.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BookingsRepo extends JpaRepository<Bookings, BigInteger> {
}
