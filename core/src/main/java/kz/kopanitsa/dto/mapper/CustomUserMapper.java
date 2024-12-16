package kz.kopanitsa.dto.mapper;

import kz.kopanitsa.dto.CustomUserDto;
import kz.kopanitsa.entity.CustomUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomUserMapper {

    CustomUserDto customUserToCustomUserDto(CustomUser customUser);

    CustomUser customUserDtoToCustomUser(CustomUserDto customUserDto);
}
