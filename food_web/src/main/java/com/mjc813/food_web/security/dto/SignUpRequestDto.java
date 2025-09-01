package com.mjc813.food_web.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.member.dto.IMember;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequestDto implements IMember {
    @JsonIgnore
    private Long id;
    private String role;

    @Size(min = 2, max = 20)
    private String name;

    @Size(min = 2, max = 20)
    private String username;

    @Size(min = 2, max = 20)
    private String password;

    @Size(min = 2, max = 20)
    private String nickName;

    @Size(min = 2, max = 15)
    private String phoneNumber;

    @Size(min = 2, max = 50)
    @Email
    private String email;
}
