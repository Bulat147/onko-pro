package ru.onko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private String exceptionName;
}
