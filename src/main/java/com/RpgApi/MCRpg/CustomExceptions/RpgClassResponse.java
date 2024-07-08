package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class RpgClassResponse {

    private String message;
    private ZonedDateTime zonedDateTime;
    HttpStatus httpStatus;

    public RpgClassResponse(String message, ZonedDateTime zonedDateTime, HttpStatus httpStatus) {
        this.message = message;
        this.zonedDateTime = zonedDateTime;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
