package kz.kopanitsa.service.impl;

import kz.kopanitsa.dto.EntertainmentDto;
import kz.kopanitsa.dto.mapper.EntertainmentMapper;
import kz.kopanitsa.entity.Entertainment;
import kz.kopanitsa.repository.EntertainmentRepository;
import kz.kopanitsa.service.EntertainmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntertainmentServiceImpl implements EntertainmentService {

    private final EntertainmentRepository entertainmentRepository;

    private final EntertainmentMapper entertainmentMapper;

    @Override
    public List<EntertainmentDto> getByName(String name) {
        return entertainmentRepository.findByName(name)
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<EntertainmentDto> getByDate(LocalDate date) {
        return entertainmentRepository.findByDate(date)
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<EntertainmentDto> getByCity(String city) {
        return entertainmentRepository.findByCity(city)
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<EntertainmentDto> getByPrice(Integer price) {
        return entertainmentRepository.findByPrice(price)
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<EntertainmentDto> getByVenue(String venue) {
        return entertainmentRepository.findByVenue(venue)
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<EntertainmentDto> getAllEntertainments() {
        return entertainmentRepository.findAll()
                .stream()
                .map(entertainment -> {
                    try {
                        return Optional.of(entertainmentMapper.entertainmentToEntertainmentDto(entertainment));
                    } catch (Exception e) {
                        System.err.println("Conversion error for entertainment: " + entertainment);
                        e.printStackTrace();
                        return Optional.<EntertainmentDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public EntertainmentDto createEntertainment(EntertainmentDto entertainmentDto) {
        Entertainment entertainment = entertainmentMapper.entertaimentDtoToEntertainment(entertainmentDto);
        if(entertainmentRepository.existsByDate(entertainment.getDate())) {
            return entertainmentDto;
        }
        if(entertainmentRepository.existsByTime(entertainment.getTime())) {
            return entertainmentDto;
        }
        Entertainment newEntertainment = entertainmentRepository.save(entertainment);
        return entertainmentMapper.entertainmentToEntertainmentDto(newEntertainment);
    }

    @Override
    public EntertainmentDto updateEntertainment(Long id, EntertainmentDto entertainmentDto) {
        Entertainment entertainment = entertainmentRepository.findById(id).orElseThrow();
        entertainment.setName(entertainmentDto.getName());
        entertainment.setDate(entertainmentDto.getDate());
        entertainment.setTime(entertainmentDto.getTime());
        entertainment.setCity(entertainmentDto.getCity());
        entertainment.setAddress(entertainmentDto.getAddress());
        entertainment.setPrice(entertainmentDto.getPrice());
        entertainment.setVenue(entertainment.getVenue());
        entertainment.setTicketlink(entertainmentDto.getTicketlink());
        Entertainment newEntertainment = entertainmentRepository.save(entertainment);
        return entertainmentMapper.entertainmentToEntertainmentDto(newEntertainment);
    }

    @Override
    public void deleteEntertainment(Long id) {
        entertainmentRepository.deleteById(id);
    }
}
