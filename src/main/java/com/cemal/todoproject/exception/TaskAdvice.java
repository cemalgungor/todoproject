package com.cemal.todoproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cemal.todoproject.exception.NotFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TaskAdvice  {
    @ExceptionHandler (value = NotFoundException.class)
    private ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {

        ErrorResponse error = new ErrorResponse("NOT_FOUND_ERROR", e.getMessage());

        error.setTimestamp(LocalDateTime.now());

        error.setStatus((HttpStatus.NOT_FOUND.value()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
