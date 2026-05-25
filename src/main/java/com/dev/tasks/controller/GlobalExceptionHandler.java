package com.dev.tasks.controller;

import com.dev.tasks.domain.dto.ErrorResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException,
     * returning a standardized error response and an HTTP 400 BAD REQUEST.
     * This exception is thrown when a @Valid validation fails.
     *
     * @param ex the exception
     * @return A standardized error response.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex) {

        // Get the first validation error message
        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).orElse("Validation Failed");

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(message);

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
