package com.example.FireAuthGateway.Controller;

import com.example.FireAuthGateway.Entity.Users;
import com.example.FireAuthGateway.Service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

/*    @GetMapping("/users/{username}")
    public Users getUsers(@PathVariable String username) {
        return usersService.getUsersDetails(username);
    }*/
@GetMapping("/users/{username}")
public Users getUsers(@PathVariable String username) {
    log.info("Fetching user details for username: {}", username);

    Users user = null;
    try {
        user = usersService.getUsersDetails(username);
        if (user != null) {
            log.info("User details fetched successfully for username: {}", username);
        } else {
            log.warn("No user found for username: {}", username);
        }
    } catch (Exception e) {
        log.error("Error occurred while fetching user details for username {}: {}", username, e.getMessage());
    }

    return user;
}
    @GetMapping("/someinfo")
    public String someinfo(){
        return "Try to sing this: Blaaaa bla blaaa bla bla!";
    }

}

