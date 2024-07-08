package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RpgClassInvalidException extends RuntimeException{

    public RpgClassInvalidException(String msg){
        super(msg);
    }
}
