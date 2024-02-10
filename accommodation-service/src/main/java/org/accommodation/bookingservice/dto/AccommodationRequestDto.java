package org.accommodation.bookingservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.accommodation.bookingservice.model.Accommodation;

@Data
@AllArgsConstructor
public class AccommodationRequestDto {

    @NotEmpty
    private Accommodation.Type type;
    @NotEmpty
    private String location;
    private String size;
    @NotNull
    private List<String> amenities;
    @Min(500)
    @NotNull
    private BigDecimal dailyRate;
    @Min(0)
    @NonNull
    private Integer availability;
}
