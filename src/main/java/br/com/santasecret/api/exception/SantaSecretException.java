package br.com.santasecret.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SantaSecretException extends RuntimeException {

    private static final long serialVersionUID = -7060729589315962389L;

    private final HttpStatus httpStatus;

    public SantaSecretException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
