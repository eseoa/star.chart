package com.blue.water.exception;

import java.io.Serial;

public class EntityAlreadyExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7482837431368086194L;

    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
