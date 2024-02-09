package org.accommodation.bookingservice.repository;

import org.accommodation.bookingservice.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
