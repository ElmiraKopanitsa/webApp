package kz.kopanitsa.service;

import kz.kopanitsa.dto.CustomUserDto;

import java.util.List;

public interface CustomUserService {

    List<CustomUserDto> getByName(String name);

    List<CustomUserDto> getByCity(String city);

    List<CustomUserDto> getByPhone(String phone);

    CustomUserDto getByEmail(String email);

    List<CustomUserDto> getByRole(String roleName);

    List<CustomUserDto> getAllCustomUser();

    CustomUserDto createCustomUser(CustomUserDto customUserDto);

    CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto);

    void deleteCustomUser(Long id);

}
