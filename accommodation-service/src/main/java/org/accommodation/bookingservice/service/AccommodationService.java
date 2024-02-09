package org.accommodation.bookingservice.service;

import java.util.List;
import org.accommodation.bookingservice.dto.AccommodationDto;
import org.accommodation.bookingservice.dto.AccommodationRequestDto;

public interface AccommodationService {
    AccommodationDto create(AccommodationRequestDto requestDto);

    List<AccommodationDto> getAllAccommodations();

    AccommodationDto getById(Long id);

    AccommodationDto updateAccommodation(Long id, AccommodationRequestDto requestDto);

    void deleteAccommodation(Long id);
}
