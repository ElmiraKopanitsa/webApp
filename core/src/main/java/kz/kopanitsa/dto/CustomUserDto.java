package kz.kopanitsa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomUserDto {

    @NotBlank
    @Size(min = 2, max = 50, message = "The name must contain at least 2 characters.")
    private String name;

    @NotBlank
    @Size(min = 2, max = 50, message = "The city must contain at least 2 characters.")
    private String city;

    @NotBlank
    @Pattern(regexp = "^\\+\\d{20}$",
            message = "Enter the telephone number in the format +ХХХХХХХХХХ")
    private String phone;

    @NotBlank
    @Email
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 50, message = "The login cannot be longer than 50 characters.")
    private String login;

    @NotBlank
    @Size(max = 50, message = "The password cannot be longer than 50 characters.")
    private String password;

}
