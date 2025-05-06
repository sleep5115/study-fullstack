package com.example.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private Long userSeq;
    private String userId;
    private String userName;
    private String userEmail;
}
