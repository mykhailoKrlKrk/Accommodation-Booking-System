package org.accommodation.bookingservice.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dao.BookingRequestDto;
import org.accommodation.bookingservice.dao.BookingResponseDto;
import org.accommodation.bookingservice.mapper.BookingMapper;
import org.accommodation.bookingservice.model.Booking;
import org.accommodation.bookingservice.repository.BookingRepository;
import org.accommodation.bookingservice.service.BookingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponseDto create(BookingRequestDto requestDto) {
        Booking model = bookingMapper.toModel(requestDto);

        model.setUserId(1L);
        return bookingMapper.toDto(bookingRepository.save(model));
    }

    @Override
    public List<BookingResponseDto> getBookingsByUserIdAndStatus(Long id, Booking.Status status) {
        return null;
    }
}
