package com.example.taskManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex){
       ErrorResponse errorResponse = new ErrorResponse(
               HttpStatus.INTERNAL_SERVER_ERROR.value(),
               "Something went wrong:"+ex.getMessage());

       return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
