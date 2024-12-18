package kz.kopanitsa.service;

import kz.kopanitsa.dto.EntertainmentDto;

import java.time.LocalDate;
import java.util.List;

public interface EntertainmentService {

    EntertainmentDto getByName(String name);

    EntertainmentDto getByDate(LocalDate date);

    EntertainmentDto getByCity(String city);

    EntertainmentDto getByPrice(Integer price);

    EntertainmentDto getByVenue(String venue);

    List<EntertainmentDto> getAllEntertainments();

    EntertainmentDto createEntertainment(EntertainmentDto entertainmentDto);

    EntertainmentDto updateEntertainment(Long id, EntertainmentDto entertainmentDto);

    void deleteEntertainment(Long id);

}
