package com.example.commonspringboot.routers.users;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data // @Getter @Setter
@NoArgsConstructor // @Bean
@AllArgsConstructor
@Builder
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}

