package org.accommodation.bookingservice.service;

import org.accommodation.bookingservice.dto.UserRegistrationRequestDto;
import org.accommodation.bookingservice.dto.UserResponseDto;
import org.accommodation.bookingservice.dto.UserUpdateRequestDto;
import org.accommodation.bookingservice.model.Role;

public interface UserService {
    UserResponseDto updateRole(Long id, Role role);

    UserResponseDto getUserProfile();

    UserResponseDto updateInfo(UserUpdateRequestDto requestDto);

    UserResponseDto register(UserRegistrationRequestDto requestDto);
}
