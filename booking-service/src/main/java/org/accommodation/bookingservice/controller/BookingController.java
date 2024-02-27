package org.accommodation.bookingservice.controller;

import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dao.BookingRequestDto;
import org.accommodation.bookingservice.dao.BookingResponseDto;
import org.accommodation.bookingservice.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public BookingResponseDto create(@RequestBody BookingRequestDto requestDto) {
        return bookingService.create(requestDto);
    }
}
