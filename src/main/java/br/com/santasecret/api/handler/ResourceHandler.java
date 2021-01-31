package br.com.santasecret.api.handler;

import br.com.santasecret.api.exception.SantaSecretException;
import br.com.santasecret.api.model.ErrorResponse;
import br.com.santasecret.api.model.ErrorResponse.ErrorResponseBuilder;
import br.com.santasecret.api.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(SantaSecretException.class)
    public ResponseEntity<Response<String>> handlerMateriaException(
            SantaSecretException sataSecretException) {
        Response<String> response = new Response<>();
        response.setStatusCode(sataSecretException.getHttpStatus().value());
        response.setData(sataSecretException.getMessage());
        return ResponseEntity.status(sataSecretException.getHttpStatus()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        ErrorResponseBuilder builder = ErrorResponse.builder();
        builder.httpStatus(HttpStatus.BAD_GATEWAY.value());
        builder.message(e.getMessage());
        builder.timeStamp(System.currentTimeMillis());
        e.getBindingResult().getAllErrors().forEach(error -> {
            String campo = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(campo, message);
        });
        builder.errors(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(builder.build());
    }

}
