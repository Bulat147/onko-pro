package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateResponse {
    private UUID id;
    private String email;
    private String state;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDateTime birthDate;
    private UUID photoId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
