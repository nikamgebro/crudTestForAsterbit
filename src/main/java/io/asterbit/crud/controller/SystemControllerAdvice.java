package io.asterbit.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class SystemControllerAdvice {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException illegalStateException) {
        var map = new HashMap<String, String>();
        map.put("message", illegalStateException.getLocalizedMessage());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        var map = new HashMap<String, String>();
        map.put("message", exception.getLocalizedMessage());
        return ResponseEntity.badRequest().body(map);
    }
}
