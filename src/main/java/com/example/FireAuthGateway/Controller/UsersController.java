package com.example.FireAuthGateway.Controller;

import com.example.FireAuthGateway.Entity.Users;
import com.example.FireAuthGateway.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:8086/"})
public class UsersController {

/*
    @Autowired
    private UsersService usersService;
*/

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping("/users")
    public String saveUsers(@RequestBody Users users) throws ExecutionException, InterruptedException {
        return usersService.saveUsers(users);
    }

    @GetMapping("/users/{username}")
    public Users getUsers(@PathVariable String username) throws ExecutionException, InterruptedException {
        return usersService.getUsersDetails(username);
    }

    @PutMapping("/users/update")
    public String updateUsers(@RequestBody Users users) throws ExecutionException, InterruptedException {
        return usersService.updateUsers(users);
    }

    @DeleteMapping("/users/delete/{username}")
    public String deleteUsers(@PathVariable String username) throws ExecutionException, InterruptedException {
        return usersService.deleteUsers(username);
    }
}

