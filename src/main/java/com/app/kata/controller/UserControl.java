package com.app.kata.controller;

import com.app.kata.component.JwtUtil;
import com.app.kata.dto.JwtResponse;
import com.app.kata.dto.LoginRequest;
import com.app.kata.entity.Users;
import com.app.kata.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserControl {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Users user = usersService.logIn(loginRequest.getCorreo(), loginRequest.getPassword());
        if (user != null) {
            String token = jwtUtil.generateToken(user.getCorreo());
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}

/*
@RestController
public class UserControl {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signin")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        Users newUser =usersService.createUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<Users> getUser(@RequestParam(name = "correo") String correo, @RequestParam(name = "pwd")String password){
        Users infoUser = usersService.logIn(correo,password);
        return new ResponseEntity<>(infoUser, HttpStatus.OK);
    }
} */
