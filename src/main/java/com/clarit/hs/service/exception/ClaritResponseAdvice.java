package com.clarit.hs.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Common Exception handler for all type of service layer exceptions
 *
 * Created by mnachiappan on Jan 8, 2023.
 *
 */
@ControllerAdvice
@RestController
public class ClaritResponseAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ItemNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
/*
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
 */

    @ExceptionHandler(UnAuthorizedException.class)
    public final ResponseEntity<ErrorDetails> handleUnauthorizedException(UnAuthorizedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(ForbiddenException.class)
    public final ResponseEntity<ErrorDetails> handleForbiddenException(ForbiddenException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

}