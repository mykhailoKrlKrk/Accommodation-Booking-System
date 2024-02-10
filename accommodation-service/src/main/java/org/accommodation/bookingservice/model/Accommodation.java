package org.accommodation.bookingservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@Table(name = "accommodations")
@SQLDelete(sql = "UPDATE accommodations SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accommodation_type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "amenities", nullable = false)
    private List<String> amenities;

    @Column(name = "dailyRate", nullable = false)
    private BigDecimal dailyRate;

    @Column(name = "availability", nullable = false)
    private Integer availability;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public enum Type {
        HOUSE,
        APARTMENT,
        CONDO,
        VACATION_HOME
    }
}
