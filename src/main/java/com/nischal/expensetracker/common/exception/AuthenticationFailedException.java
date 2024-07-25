package com.nischal.expensetracker.common.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author : Nischal on 7/25/2024
 */

public class AuthenticationFailedException extends AuthenticationException {
    public AuthenticationFailedException() {
        super("unauthorized");
    }
}
