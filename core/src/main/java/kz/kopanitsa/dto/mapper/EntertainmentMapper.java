package kz.kopanitsa.dto.mapper;

import kz.kopanitsa.dto.EntertainmentDto;
import kz.kopanitsa.entity.Entertainment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntertainmentMapper {

    EntertainmentDto entertainmentToEntertainmentDto(Entertainment entertainment);

    Entertainment entertaimentDtoToEntertainment(EntertainmentDto entertainmentDto);
}
