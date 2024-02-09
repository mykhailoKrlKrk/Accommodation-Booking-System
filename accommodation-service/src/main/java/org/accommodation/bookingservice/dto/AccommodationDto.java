package org.accommodation.bookingservice.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.accommodation.bookingservice.model.Accommodation;

@Data
public class AccommodationDto {
    private Long id;
    private Accommodation.Type type;
    private String location;
    private String size;
    private List<String> amenities;
    private BigDecimal dailyRate;
    private Integer availability;
}
