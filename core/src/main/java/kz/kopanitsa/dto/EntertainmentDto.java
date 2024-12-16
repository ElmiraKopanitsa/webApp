package kz.kopanitsa.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class EntertainmentDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "The name must contain at least 2 characters.")
    private String name;

    @NotBlank
    @FutureOrPresent(message = "The date must not be in the past.")
    private LocalDate date;

    @NotBlank
    @FutureOrPresent(message = "The time must not be in the past.")
    private LocalTime time;

    @NotBlank
    @Size(min = 2, max = 50, message = "The city must contain at least 2 characters.")
    private String city;

    @NotBlank
    @Size(min = 10, max = 50, message = "The city must contain at least 10 characters.")
    private String address;

    @NotBlank
    @PositiveOrZero(message = "The value must be zero or a positive integer.")
    private Integer price;

    @NotBlank
    @Size(min = 2, max = 50, message = "The venue must contain at least 2 characters.")
    private String venue;
    @NotBlank
    private String ticketlink;
}
