package org.accommodation.bookingservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.accommodation.bookingservice.dto.AccommodationDto;
import org.accommodation.bookingservice.dto.AccommodationRequestDto;
import org.accommodation.bookingservice.service.AccommodationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
