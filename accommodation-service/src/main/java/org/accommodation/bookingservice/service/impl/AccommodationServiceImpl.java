package org.accommodation.bookingservice.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dto.AccommodationDto;
import org.accommodation.bookingservice.dto.AccommodationRequestDto;
import org.accommodation.bookingservice.mapper.AccommodationMapper;
import org.accommodation.bookingservice.model.Accommodation;
import org.accommodation.bookingservice.repository.AccommodationRepository;
import org.accommodation.bookingservice.service.AccommodationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationMapper accommodationMapper;

    @Override
    public AccommodationDto create(AccommodationRequestDto requestDto) {
        Accommodation accommodation = accommodationMapper.toModel(requestDto);
        return accommodationMapper.toDto(accommodationRepository.save(accommodation));
    }

    @Override
    public List<AccommodationDto> getAllAccommodations() {
        return accommodationRepository.findAll().stream()
                .map(accommodationMapper::toDto)
                .toList();
    }

    @Override
    public AccommodationDto getById(Long id) {
        return accommodationRepository.findById(id)
                .map(accommodationMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Can't find accommodation by id: " + id));
    }

    @Override
    public AccommodationDto updateAccommodation(Long id, AccommodationRequestDto requestDto) {
        getById(id);
        Accommodation accommodation = accommodationMapper.toModel(requestDto);
        accommodation.setId(id);
        return accommodationMapper.toDto(accommodation);
    }

    @Override
    public void deleteAccommodation(Long id) {
        getById(id);
        accommodationRepository.deleteById(id);
    }
}
