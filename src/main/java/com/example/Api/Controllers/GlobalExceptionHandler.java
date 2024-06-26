package com.example.Api.Controllers;

import com.example.Application.Common.Error;
import com.example.Application.Common.InvalidCredentialsError;
import com.example.Application.Common.UserAlreadyExistsError;
import com.example.Application.Common.ProblemFactory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ProblemFactory problemFactory;

    
       @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCredentialsError.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Problem> handleInvalidCredentialsError(InvalidCredentialsError ex) {
        Problem problem = problemFactory.createUnauthorizedProblem(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problem);
    }

    @ExceptionHandler(UserAlreadyExistsError.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Problem> handleUserAlreadyExistsError(UserAlreadyExistsError ex) {
        Problem problem = problemFactory.createCustomProblem(Status.CONFLICT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

    @ExceptionHandler(Error.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Problem> handleApplicationError(Error ex) {
        Problem problem = problemFactory.createBadRequestProblem(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Problem> handleGenericException(Exception ex) {
        Problem problem = problemFactory.createInternalServerErrorProblem(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problem);
    }
}
