package com.example.commonspringboot.routers.users;

import com.example.commonspringboot.exception.ControlledException;
import com.example.commonspringboot.exception.errorcode.UsersErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public Users create(UsersDTO usersDTO) {
        var newUser = Users.builder()
                .email(usersDTO.getEmail())
                .password(passwordEncoder.encode(usersDTO.getPassword()))
                .username(usersDTO.getUsername())
                .build();

        return usersRepository.save(newUser);
    }

    public Users update(UsersDTO usersDTO) {
        var user = usersRepository.findById(usersDTO.getId())
                .orElseThrow(() -> new ControlledException(UsersErrorCode.UserNotFound));

        if(usersDTO.getEmail() != null)
            user.setEmail(usersDTO.getEmail());
        if(usersDTO.getPassword() != null)
            user.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        if(usersDTO.getUsername() != null)
            user.setUsername(usersDTO.getUsername());
        user.setUpdatedAt(LocalDateTime.now());

        return usersRepository.save(user);
    }

    public Users delete(Long id) {
        var user = usersRepository.findById(id)
                .orElseThrow(() -> new ControlledException(UsersErrorCode.UserNotFound));

        usersRepository.delete(user);
        return user;
    }

    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new ControlledException(UsersErrorCode.UserNotFound));
    }

    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new ControlledException(UsersErrorCode.UserNotFound));
    }

    public List<Users> findByUsername(String username) {
        return usersRepository.findByUsername(username)
                .orElseThrow(() -> new ControlledException(UsersErrorCode.UserNotFound));
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }
}
