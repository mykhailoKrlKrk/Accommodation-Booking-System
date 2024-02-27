package org.accommodation.bookingservice.mapper;

import org.accommodation.bookingservice.config.MapperConfig;
import org.accommodation.bookingservice.dao.BookingRequestDto;
import org.accommodation.bookingservice.dao.BookingResponseDto;
import org.accommodation.bookingservice.model.Booking;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookingMapper {
    Booking toModel(BookingRequestDto requestDto);

    BookingResponseDto toDto(Booking booking);
}
