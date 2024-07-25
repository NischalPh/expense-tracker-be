package com.nischal.expensetracker;

import com.nischal.expensetracker.common.constant.ApiConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Nischal on 7/24/2024
 */

@RestController
public class TestController {

    @GetMapping(ApiConstant.PING)
    public ResponseEntity checkServerStatus() {
        String message = "Server is up and running";
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
