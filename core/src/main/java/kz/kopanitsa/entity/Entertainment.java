package kz.kopanitsa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "entertainments")
public class Entertainment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private String venue;
    @Column(nullable = false)
    private String ticketlink;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entertainment that = (Entertainment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(city, that.city) &&
                Objects.equals(address, that.address) &&
                Objects.equals(price, that.price) &&
                Objects.equals(venue, that.venue) &&
                Objects.equals(ticketlink, that.ticketlink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, time, city, address, price, venue, ticketlink);
    }
    
}
