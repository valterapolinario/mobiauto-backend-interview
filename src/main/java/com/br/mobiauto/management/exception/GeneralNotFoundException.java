package com.br.mobiauto.management.exception;

import lombok.Getter;

@Getter
public class GeneralNotFoundException extends RuntimeException {

    private final Object valueNotFound;

    public GeneralNotFoundException(String message, Object valueNotFound) {
        super(message);
        this.valueNotFound = valueNotFound;
    }

}
