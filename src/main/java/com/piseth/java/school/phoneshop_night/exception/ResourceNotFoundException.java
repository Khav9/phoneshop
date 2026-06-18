package com.piseth.java.school.phoneshop_night.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{
    public ResourceNotFoundException(String resouceName, Integer id) {
        super(HttpStatus.NOT_FOUND, String.format("%s with id = %d not found", resouceName, id));
    }
}
