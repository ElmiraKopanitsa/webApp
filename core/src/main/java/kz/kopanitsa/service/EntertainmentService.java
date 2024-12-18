package kz.kopanitsa.service;

import kz.kopanitsa.dto.EntertainmentDto;
import kz.kopanitsa.entity.Entertainment;

import java.time.LocalDate;
import java.util.List;

public interface EntertainmentService {

    List<EntertainmentDto> getByName(String name);

    List<EntertainmentDto> getByDate(LocalDate date);

    List<EntertainmentDto> getByCity(String city);

    List<EntertainmentDto> getByPrice(Integer price);

    List<EntertainmentDto> getByVenue(String venue);

    List<EntertainmentDto> getAllEntertainments();

    EntertainmentDto createEntertainment(EntertainmentDto entertainmentDto);

    EntertainmentDto updateEntertainment(Long id, EntertainmentDto entertainmentDto);

    void deleteEntertainment(Long id);

}
