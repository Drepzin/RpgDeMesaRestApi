package com.RpgApi.MCRpg.CustomExceptions;

import com.RpgApi.MCRpg.Models.RpgClass;

public class RpgClassExistentException extends RuntimeException{

    public RpgClassExistentException(String msg){
        super(msg);
    }
}
