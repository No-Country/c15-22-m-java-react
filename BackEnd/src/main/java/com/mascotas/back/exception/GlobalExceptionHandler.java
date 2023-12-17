package com.mascotas.back.exception;

import com.mascotas.back.exception.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Cuando la validación de un argumento anotado con @Valid falla.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors().stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    public record DataErrorValidation(String campo, String error) {
        public DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

    // Para validaciones de Path en los endpoints como los id's
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(
                                                    exception.getMessage(),
                                                    webRequest.getDescription(false) // Solo devuelve la URI y omite otros datos sensibles.
                                                 );
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Para validaciones con desconexion de la base de datos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handlerException(Exception exception, WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}