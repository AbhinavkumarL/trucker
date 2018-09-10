package io.egen.capstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class VehicleVinAlreadyExistsException extends RuntimeException{
    public VehicleVinAlreadyExistsException(String message) {super(message);}
}
