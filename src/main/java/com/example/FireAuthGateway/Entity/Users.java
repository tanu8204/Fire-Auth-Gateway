package com.example.FireAuthGateway.Entity;


import lombok.*;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    @Id //from data jpa dependency
    private String username;
    private String password;

}
