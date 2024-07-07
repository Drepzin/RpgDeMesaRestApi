package com.RpgApi.MCRpg.Handlers;

import com.RpgApi.MCRpg.CustomExceptions.APINotFoundException;
import com.RpgApi.MCRpg.CustomExceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@ControllerAdvice
@RestController
public class PlayerExceptionHandler{

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<APINotFoundException> playerNotFound(NotFoundException e){

        HttpStatus notFound = HttpStatus.NOT_FOUND;

        APINotFoundException nfe = new APINotFoundException(
                e.getMessage(),
                ZonedDateTime.now(),
                notFound
        );
        return new ResponseEntity<>(nfe, notFound);
    }
}
