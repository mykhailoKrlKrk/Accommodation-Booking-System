package org.accommodation.bookingservice.mapper;

import org.accommodation.bookingservice.config.MapperConfig;
import org.accommodation.bookingservice.dto.AccommodationDto;
import org.accommodation.bookingservice.dto.AccommodationRequestDto;
import org.accommodation.bookingservice.model.Accommodation;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AccommodationMapper {
    AccommodationDto toDto(Accommodation accommodation);

    Accommodation toModel(AccommodationRequestDto requestDto);
}
