package com.nischal.expensetracker.common.exception.handler;

import com.nischal.expensetracker.common.builder.ResponseBuilder;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.exception.ResourceNotFoundException;
import com.nischal.expensetracker.common.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author : Nischal on 7/23/2024
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> resourceNotFound(ResourceNotFoundException ex) {
        LogUtil.exception(ex.getMessage());
        Response response = ResponseBuilder.failure(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
