package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse {
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
