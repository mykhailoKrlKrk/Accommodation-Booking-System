package org.accommodation.bookingservice.dao;

import java.time.LocalDate;
import lombok.Data;
import org.accommodation.bookingservice.model.Booking;

@Data
public class BookingRequestDto {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long accommodationId;
    private Booking.Status status;
}
