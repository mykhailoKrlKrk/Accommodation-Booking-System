package org.accommodation.bookingservice.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequestDto {
    @Size(min = 4, max = 50)
    private String email;
    private String password;
}
