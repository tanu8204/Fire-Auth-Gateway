package com.example.FireAuthGateway.Controller;

//import com.example.FireAuthGateway.Entity.Users;
//import com.example.FireAuthGateway.Service.UsersService;

import com.example.FireAuthGateway.Entity.Users;
import com.example.FireAuthGateway.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users/{username}")
    public Users getUsers(@PathVariable String username) throws ExecutionException, InterruptedException {
        return usersService.getUsersDetails(username);
    }
    @GetMapping("/someinfo")
    public String someinfo(){
        return "Try to sing this: Blaaaa bla blaaa bla bla!";
    }
    @GetMapping("/otherinfo")
    public String otherinfo(){
        return "Weather forecast: Nice and rainy";
    }

    @GetMapping("/tomorrow")
    public String tomorrow(){
        return "Snow...";
    }
}

