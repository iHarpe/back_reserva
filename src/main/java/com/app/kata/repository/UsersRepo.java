package com.app.kata.repository;

import com.app.kata.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface UsersRepo extends JpaRepository<Users, BigInteger> {

    Users findByCorreoAndPassword(String correo, String password);
}
