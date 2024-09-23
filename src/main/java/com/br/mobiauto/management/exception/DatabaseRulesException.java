package com.br.mobiauto.management.exception;

import lombok.Getter;

@Getter
public class DatabaseRulesException extends RuntimeException {

    private final Object valueForConflict;

    public DatabaseRulesException(String message, Object valueForConflict) {
        super(message);
        this.valueForConflict = valueForConflict;
    }

}
