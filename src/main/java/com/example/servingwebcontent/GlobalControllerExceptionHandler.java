package com.example.servingwebcontent;

import org.json.JSONObject;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<String> handleConflict(RuntimeException ex) {
        JSONObject response = new JSONObject();
        response.put("success", false);
        response.put("description", "No Method");
        System.out.print( ANSI_YELLOW + ex + ANSI_RESET );
        return new ResponseEntity<String>(response.toString(), HttpStatus.CREATED);
    }
}