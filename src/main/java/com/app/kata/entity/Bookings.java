package com.app.kata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(name="bookings") @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bookings {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDBOOKING", nullable = false)
    private BigInteger IDBOOKING;
    @Column(name="FECHARESERVA", nullable=false)
    private LocalDateTime FECHARESERVA;
    @Column(name = "EVENTORSV", nullable = false)
    private BigInteger EVENTORSV;

}
