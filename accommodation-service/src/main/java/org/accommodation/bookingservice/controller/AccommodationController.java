package org.accommodation.bookingservice.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dto.AccommodationDto;
import org.accommodation.bookingservice.dto.AccommodationRequestDto;
import org.accommodation.bookingservice.service.AccommodationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AccommodationController", description = "Controller for managing accommodations")
@RestController
@RequestMapping("/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccommodationDto createAccommodation(@RequestBody
                                                    AccommodationRequestDto requestDto) {
        return accommodationService.create(requestDto);
    }

    @GetMapping
    public List<AccommodationDto> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/{id}")
    public AccommodationDto getById(@PathVariable Long id) {
        return accommodationService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccommodationDto update(@PathVariable Long id,
                                   @RequestBody AccommodationRequestDto requestDto) {
        return accommodationService.updateAccommodation(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        accommodationService.deleteAccommodation(id);
    }
}
