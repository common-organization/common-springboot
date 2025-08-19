package com.example.commonspringboot.routers.users;

import com.example.commonspringboot.commons.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid UsersDTO usersDTO) {
        var user = usersService.create(usersDTO);

        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 생성 성공").data(user).build());
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody @Valid UsersDTO usersDTO) {
        var user = usersService.update(usersDTO);
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 수정 성공").data(user).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        var user = usersService.delete(id);
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 삭제 성공").data(user).build());
    }

    @GetMapping
    public ResponseEntity readAll() {
        var users = usersService.findAll();
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 전체 조회 성공").data(users).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity readById(@PathVariable Long id) {
        var users = usersService.findById(id);
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 조회 성공").data(users).build());
    }

    @GetMapping("/email/{email}")
    public  ResponseEntity readByEmail(@PathVariable String email) {
        var users = usersService.findByEmail(email);
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 조회 성공").data(users).build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity readByUsername(@PathVariable String username) {
        var users = usersService.findByUsername(username);
        return ResponseEntity.ok(CommonResponse.builder().code(200).message("유저 조회 성공").data(users).build());
    }
}