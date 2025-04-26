package com.ashhh.user.service.Exception;

import com.ashhh.user.service.payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> handleResourceNotFoundException(ResourceNotFoundException ex)
    {

        String message=ex.getMessage();
       ApiResponce responce= ApiResponce.builder().
                message(message).
                success(true).
                status(HttpStatus.NOT_FOUND).build();

       return new ResponseEntity<ApiResponce>(responce,HttpStatus.NOT_FOUND);


   }
}
