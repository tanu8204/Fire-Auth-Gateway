package com.example.FireAuthGateway.Controller;

import com.example.FireAuthGateway.Entity.Users;
import com.example.FireAuthGateway.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public String saveUsers(@RequestBody Users users) throws ExecutionException, InterruptedException {
        return usersService.saveUsers(users);
    }

    @GetMapping("/users/{username}")
    public Users getUsers(@PathVariable String username) throws ExecutionException, InterruptedException {
        return usersService.getUsersDetails(username);
    }

}
