package kz.kopanitsa.service.impl;

import kz.kopanitsa.dto.CustomUserDto;
import kz.kopanitsa.dto.mapper.CustomUserMapper;
import kz.kopanitsa.entity.CustomUser;
import kz.kopanitsa.entity.Role;
import kz.kopanitsa.repository.CustomUserRepository;
import kz.kopanitsa.repository.RoleRepository;
import kz.kopanitsa.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserServiceImpl implements CustomUserService {

    private final CustomUserRepository customUserRepository;

    private final RoleRepository roleRepository;

    private final CustomUserMapper customUserMapper;

    @Override
    public List<CustomUserDto> getByName(String name) {
        return customUserRepository.findByName(name)
                .stream()
                .map(customUser -> {
                    try {
                        return Optional.of(customUserMapper.customUserToCustomUserDto(customUser));
                    } catch (Exception e) {
                        System.err.println("Conversion error for user: " + customUser);
                        e.printStackTrace();
                        return Optional.<CustomUserDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomUserDto> getByCity(String city) {
        return customUserRepository.findByCity(city)
                .stream()
                .map(customUser -> {
                    try {
                        return Optional.of(customUserMapper.customUserToCustomUserDto(customUser));
                    } catch (Exception e) {
                        System.err.println("Conversion error for user: " + customUser);
                        e.printStackTrace();
                        return Optional.<CustomUserDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomUserDto> getByPhone(String phone) {
        return customUserRepository.findByPhone(phone)
                .stream()
                .map(customUser -> {
                    try {
                        return Optional.of(customUserMapper.customUserToCustomUserDto(customUser));
                    } catch (Exception e) {
                        System.err.println("Conversion error for user: " + customUser);
                        e.printStackTrace();
                        return Optional.<CustomUserDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public CustomUserDto getByEmail(String email) {
        try {
            CustomUser customUser = customUserRepository.findByEmail(email).orElseThrow();
            return customUserMapper.customUserToCustomUserDto(customUser);
        } catch (Exception e) {
            System.err.println("Conversion error for user with email: " + email);
            e.printStackTrace();
            return null; // Или выбросить новое исключение, если нужно
        }
    }

    @Override
    public List<CustomUserDto> getByRole(String roleName) {
        return customUserRepository.findByRoleName(roleName)
                .stream()
                .map(customUser -> {
                    try {
                        return Optional.of(customUserMapper.customUserToCustomUserDto(customUser));
                    } catch (Exception e) {
                        System.err.println("Conversion error for user: " + customUser);
                        e.printStackTrace();
                        return Optional.<CustomUserDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomUserDto> getAllCustomUser() {
        return customUserRepository.findAll()
                .stream()
                .map(customUser -> {
                    try {
                        return Optional.of(customUserMapper.customUserToCustomUserDto(customUser));
                    } catch (Exception e) {
                        System.err.println("Conversion error for user: " + customUser);
                        e.printStackTrace();
                        return Optional.<CustomUserDto>empty();
                    }
                })
                .flatMap(Optional::stream) // Убираем пустые элементы
                .collect(Collectors.toList());
    }

    @Override
    public CustomUserDto createCustomUser(CustomUserDto customUserDto) {
        CustomUser customUser = customUserMapper.customUserDtoToCustomUser(customUserDto);
        if(customUserRepository.existsByEmail(customUser.getEmail())) {
            return customUserDto;
        }
        if(customUserRepository.existsByPhone(customUser.getPhone())) {
            return customUserDto;
        }
        Set<Role> roles = roleRepository.findById(1L).stream().collect(Collectors.toSet());
        customUser.setRoles(roles);
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public CustomUserDto updateCustomUser(Long id, CustomUserDto customUserDto) {
        CustomUser customUser = customUserRepository.findById(id).orElseThrow();
        customUser.setName(customUserDto.getName());
        customUser.setCity(customUserDto.getCity());
        customUser.setPhone(customUserDto.getPhone());
        customUser.setEmail(customUserDto.getEmail());
        customUser.setLogin(customUserDto.getLogin());
        customUser.setPassword(customUserDto.getPassword());
        CustomUser newCustomerUser = customUserRepository.save(customUser);
        return customUserMapper.customUserToCustomUserDto(newCustomerUser);
    }

    @Override
    public void deleteCustomUser(Long id) {
        customUserRepository.deleteById(id);
    }
}
