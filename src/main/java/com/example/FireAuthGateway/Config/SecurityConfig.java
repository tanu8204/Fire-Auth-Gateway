package com.example.FireAuthGateway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    //builder design pattern
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST,"/api/users/**").authenticated()
                        .requestMatchers(HttpMethod.GET,"/api/users/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE,"/api/users/**").authenticated()
                        .requestMatchers(HttpMethod.PUT,"/api/users/**").authenticated()
                        .anyRequest().denyAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
