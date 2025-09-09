package bernadinusnaisau.spring.webmvc.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler
    public ResponseEntity<String>methodArgumentNotValidExeception(MethodArgumentNotValidException methodArgumentNotValidException) {
        return new ResponseEntity<>("Method Not Valid Exeception :", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String>constraintViolationExeception(ConstraintViolationException constraintViolationException) {
        return new ResponseEntity<>("Constraint Violation Exeception :", HttpStatus.BAD_REQUEST);
    }

}
