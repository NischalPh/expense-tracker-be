package com.nischal.expensetracker.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@Builder
@ToString
public class Response implements Serializable {

    private Boolean success;
    private String message;
    private Object data;

}
