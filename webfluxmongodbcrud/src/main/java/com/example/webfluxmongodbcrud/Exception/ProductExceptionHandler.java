package com.example.webfluxmongodbcrud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

        @ExceptionHandler(CustomException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public ErrorMessage handlerProductNotFoundException(CustomException ex) {

            return ErrorMessage.builder()
                    .message(ex.getMessage())
                    .build();

        }
}
