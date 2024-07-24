package com.nischal.expensetracker.common.builder;

import com.nischal.expensetracker.common.dto.Response;

/**
 * @Author : Nischal on 7/20/2024
 */
public class ResponseBuilder {

    public static Response success(String message, Object object) {
        return Response
                .builder()
                .success(true)
                .message(message)
                .data(object)
                .build();
    }

    public static Response success(String message) {
        return Response
                .builder()
                .success(true)
                .message(message)
                .build();
    }

    public static Response failure(String message) {
        return Response
                .builder()
                .success(false)
                .message(message)
                .build();
    }

    public static Response failure(String message, Object data) {
        return Response
                .builder()
                .success(false)
                .data(data)
                .message(message)
                .build();
    }

}
