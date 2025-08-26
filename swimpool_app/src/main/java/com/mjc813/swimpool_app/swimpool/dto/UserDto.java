package com.mjc813.swimpool_app.swimpool.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    private Integer maxLock;
}
