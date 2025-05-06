package com.example.user.controller;

import com.example.user.domain.User;
import com.example.user.dto.UserResponseDto;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public UserResponseDto  getUser(@PathVariable String userId) {
        User user = userService.findUserById(userId);
        // http://localhost:8080/api/user/xxx -> @@@ userName : OOO
        if (user != null) {
            System.out.println("@@@ userName : " +  user.getUserName());
            return new UserResponseDto(
                    user.getUserSeq(),
                    user.getUserId(),
                    user.getUserName(),
                    user.getUserEmail()
            );
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }
}
