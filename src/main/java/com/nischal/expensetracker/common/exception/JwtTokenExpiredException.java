package com.nischal.expensetracker.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author : Nischal on 7/25/2024
 */

public class JwtTokenExpiredException extends AuthenticationException {
    public JwtTokenExpiredException(String msg) {
        super(msg);
    }
}
