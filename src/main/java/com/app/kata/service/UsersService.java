package com.app.kata.service;

import com.app.kata.entity.Users;
import com.app.kata.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepo usersRepo;

    public Users createUser(Users usuario){
        return usersRepo.save(usuario);
    }

    public Users logIn(String correo, String passwd) {
        return usersRepo.findByCorreoAndPassword(correo,passwd);
    }

}
