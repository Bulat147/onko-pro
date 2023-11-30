package ru.onko.aspects;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.onko.dto.response.ExceptionDto;
import ru.onko.dto.response.ValidationExceptionDto;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationExceptionDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ValidationExceptionDto> exceptions = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            String fieldName = ((FieldError) error).getField();
            exceptions.add(ValidationExceptionDto.builder()
                    .field(fieldName)
                    .message(message)
                    .build());
        });
        return exceptions;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationExceptionDto> handleConstraintViolationException(ConstraintViolationException ex) {
        List<ValidationExceptionDto> exceptions = new ArrayList<>();
        ex.getConstraintViolations().forEach(error -> {
            String message = error.getMessage();
            exceptions.add(ValidationExceptionDto.builder()
                    .message(message)
                    .build());
        });
        return exceptions;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handleApplicationRuntimeException(RuntimeException ex) {
        return ExceptionDto.builder()
                .message(ex.getMessage())
                .exceptionName(ex.getClass().getSimpleName())
                .build();
    }

}
