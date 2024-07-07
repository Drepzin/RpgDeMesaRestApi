package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.ZonedDateTime;

public class APINotFoundException {

    private String message;
    private ZonedDateTime zonedDateTime;
    HttpStatus htp;

    public APINotFoundException(String message,
                                ZonedDateTime zonedDateTime,
                                HttpStatus htp) {
        this.message = message;
        this.zonedDateTime = zonedDateTime;
        this.htp = htp;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public HttpStatus getHtp() {
        return htp;
    }
}
