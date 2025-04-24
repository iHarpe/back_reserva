package com.app.kata.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity(name="usersapp") @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDUSER", nullable = false)
    private BigInteger IDUSER;
    @Column(name="NOMBRE", nullable=false, length=120)
    private String nombre;
    @Column(name="CORREO", nullable=false, length=70)
    private String correo;
    @Column(name="PASSWORD", nullable=false, length=70)
    private String password;

}
