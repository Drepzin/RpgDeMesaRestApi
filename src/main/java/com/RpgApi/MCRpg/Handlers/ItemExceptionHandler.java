package com.RpgApi.MCRpg.Handlers;

import com.RpgApi.MCRpg.CustomExceptions.InvalidItemException;
import com.RpgApi.MCRpg.CustomExceptions.InvalidItemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@ControllerAdvice
public class ItemExceptionHandler {

    @ExceptionHandler(InvalidItemException.class)
    public ResponseEntity<InvalidItemResponse> invalidItem(InvalidItemException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        InvalidItemResponse invalidItemResponse = new InvalidItemResponse(
                e.getLocalizedMessage(),
                ZonedDateTime.now(),
                httpStatus
        );
        return new ResponseEntity<>(invalidItemResponse, invalidItemResponse.getHttpStatus());
    }
}
