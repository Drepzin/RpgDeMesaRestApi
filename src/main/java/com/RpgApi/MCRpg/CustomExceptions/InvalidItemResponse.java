package com.RpgApi.MCRpg.CustomExceptions;


import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class InvalidItemResponse {

    private String msg;

    private ZonedDateTime zonedDateTime;

    private HttpStatus httpStatus;

    public InvalidItemResponse(String msg, ZonedDateTime zonedDateTime,
                               HttpStatus httpStatus){
        this.httpStatus = httpStatus;
        this.msg = msg;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMsg() {
        return msg;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
