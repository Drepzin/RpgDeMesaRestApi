package com.RpgApi.MCRpg.CustomExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidItemException extends RuntimeException{

    public InvalidItemException(String msg){
        super(msg);
    }
}
