package com.RpgApi.MCRpg.Handlers;

import com.RpgApi.MCRpg.CustomExceptions.RpgClassExistentException;
import com.RpgApi.MCRpg.CustomExceptions.RpgClassInvalidException;
import com.RpgApi.MCRpg.CustomExceptions.RpgClassResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@ControllerAdvice
public class RpgClassExceptionHandler {

    @ExceptionHandler(value = RpgClassInvalidException.class)
    public ResponseEntity<RpgClassResponse> classNotFound(RpgClassInvalidException e){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        RpgClassResponse rpgClassResponse = new RpgClassResponse(
                e.getMessage(),
                ZonedDateTime.now(),
                httpStatus
        );
        return new ResponseEntity<>(rpgClassResponse, httpStatus);
    }

    @ExceptionHandler(value = RpgClassExistentException.class)
    public ResponseEntity<RpgClassResponse> classExistent(RpgClassExistentException e){

        HttpStatus httpStatus = HttpStatus.NOT_IMPLEMENTED;
        RpgClassResponse rpgClassResponse = new RpgClassResponse(
                e.getMessage(),
                ZonedDateTime.now(),
                httpStatus
        );
        return new ResponseEntity<>(rpgClassResponse, httpStatus);
    }
}
