package org.accommodation.bookingservice.dto;

import lombok.Data;

@Data
public class UserUpdateRequestDto {
    private String email;
    private String firstName;
    private String lastName;
}
