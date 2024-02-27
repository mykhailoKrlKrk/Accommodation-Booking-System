package org.accommodation.bookingservice.service;

import java.util.List;
import org.accommodation.bookingservice.dao.BookingRequestDto;
import org.accommodation.bookingservice.dao.BookingResponseDto;
import org.accommodation.bookingservice.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    BookingResponseDto create(BookingRequestDto requestDto);

    List<BookingResponseDto> getBookingsByUserIdAndStatus(Long id, Booking.Status status);
}
