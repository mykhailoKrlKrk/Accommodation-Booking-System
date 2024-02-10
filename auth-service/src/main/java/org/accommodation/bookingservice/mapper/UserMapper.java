package org.accommodation.bookingservice.mapper;

import org.accommodation.bookingservice.config.MapperConfig;
import org.accommodation.bookingservice.dto.UserRegistrationRequestDto;
import org.accommodation.bookingservice.dto.UserResponseDto;
import org.accommodation.bookingservice.dto.UserUpdateRequestDto;
import org.accommodation.bookingservice.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);
    User mapToUpdated(UserUpdateRequestDto requestDto);
    User toModel(UserRegistrationRequestDto requestDto);
}
