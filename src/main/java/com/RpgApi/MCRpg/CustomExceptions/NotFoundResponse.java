package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class NotFoundResponse {

    private String message;
    private ZonedDateTime zonedDateTime;
    private HttpStatus http_status;

    public NotFoundResponse(String message,
                            ZonedDateTime zonedDateTime,
                            HttpStatus http) {
        this.message = message;
        this.zonedDateTime = zonedDateTime;
        this.http_status = http;
    }

    public String getMessage() {return message;}

    public ZonedDateTime getZonedDateTime() {return zonedDateTime;}

    public HttpStatus getHtp() {return http_status;}
}
