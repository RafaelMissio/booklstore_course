package com.rafaelmissio.bookstoremagener.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class BooksExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object>handleEntityNotFoundExcxeption(EntityNotFoundException exception){
        return buildResponseEntity(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        List<String> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> errors.add("Field " + fieldError.getField().toUpperCase() + " " + fieldError.getDefaultMessage()));
        exception.getBindingResult().getGlobalErrors()
                .forEach(getGlobalErrors -> errors.add("Object " + getGlobalErrors.getObjectName() + " " + getGlobalErrors.getDefaultMessage()));

        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                "Informed argument(s) validation error(s)",
                errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException expection, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                "Malformed JSON body and/or field erro",
                Collections.singletonList(expection.getLocalizedMessage()));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object>handleEntityExistsException(EntityExistsException exception){
        return buildResponseEntity(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors){
        ApiError apiError = ApiError.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(httpStatus).body(apiError);
    }

}
