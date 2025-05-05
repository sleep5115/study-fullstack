package com.example.backend.controller;

import com.example.backend.domain.User;
import com.example.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public int getUser(@PathVariable String userId) {
        User user = userService.findUserById(userId);
        // http://localhost:8080/api/user/xxx -> @@@ userName : OOO
        if (user != null) {
            System.out.println("@@@ userName : " +  user.getUserName());
        }
        return (user != null) ? 1 : 2;
    }
}
