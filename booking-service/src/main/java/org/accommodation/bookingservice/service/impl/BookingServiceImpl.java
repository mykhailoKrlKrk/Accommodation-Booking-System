package org.accommodation.bookingservice.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dao.BookingRequestDto;
import org.accommodation.bookingservice.dao.BookingResponseDto;
import org.accommodation.bookingservice.dao.UserResponseDto;
import org.accommodation.bookingservice.mapper.BookingMapper;
import org.accommodation.bookingservice.model.Booking;
import org.accommodation.bookingservice.repository.BookingRepository;
import org.accommodation.bookingservice.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final WebClient webClient;

    @Override
    public BookingResponseDto create(BookingRequestDto requestDto) {
        Booking model = bookingMapper.toModel(requestDto);

//        UserResponseDto userResponseDto = webClient.get()
//                .uri("http://localhost:8081/api/users")
//                .retrieve()
//                .bodyToMono(UserResponseDto.class)
//                        .block();
//
        model.setUserId(1L);
        return bookingMapper.toDto(bookingRepository.save(model));
    }

    @Override
    public List<BookingResponseDto> getBookingsByUserIdAndStatus(Long id, Booking.Status status) {
        return null;
    }
}
