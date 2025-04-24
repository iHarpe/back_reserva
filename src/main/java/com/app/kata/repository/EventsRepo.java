package com.app.kata.repository;

import com.app.kata.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EventsRepo extends JpaRepository<Events, BigInteger> {
}
