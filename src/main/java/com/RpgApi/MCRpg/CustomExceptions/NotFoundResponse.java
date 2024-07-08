package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class NotFoundResponse {

    private String message;
    private ZonedDateTime zonedDateTime;
    HttpStatus htp;

    public NotFoundResponse(String message,
                            ZonedDateTime zonedDateTime,
                            HttpStatus htp) {
        this.message = message;
        this.zonedDateTime = zonedDateTime;
        this.htp = htp;
    }

    public String getMessage() {return message;}

    public ZonedDateTime getZonedDateTime() {return zonedDateTime;}

    public HttpStatus getHtp() {return htp;}
}
