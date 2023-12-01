package ru.onko.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountSignUpRequest {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private LocalDateTime birthDate;
}
