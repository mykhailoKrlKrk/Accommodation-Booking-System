package org.accommodation.bookingservice.controller;

import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dto.UserResponseDto;
import org.accommodation.bookingservice.dto.UserUpdateRequestDto;
import org.accommodation.bookingservice.model.Role;
import org.accommodation.bookingservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public UserResponseDto updateUserRole(@PathVariable Long id, @RequestBody Role role) {
        return userService.updateRole(id, role);
    }

    @GetMapping
    public UserResponseDto getUserProfile() {
        return userService.getUserProfile();
    }

    @PutMapping
    public UserResponseDto updateUserInfo(@RequestBody UserUpdateRequestDto requestDto) {
        return userService.updateInfo(requestDto);
    }

}
