package org.accommodation.bookingservice.dao;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BookingResponseDto {
    private String id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long accommodationId;
}
