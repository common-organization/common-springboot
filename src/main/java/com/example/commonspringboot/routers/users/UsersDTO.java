package com.example.commonspringboot.routers.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
    private Long id;
    private String email;
    private String password;
    private String username;
}
