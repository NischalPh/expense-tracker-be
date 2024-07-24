package com.nischal.expensetracker.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : Nischal on 7/23/2024
 */

@Getter
@Setter
@Builder
public class ExpenseResponse {

    private String description;
    private Double amount;
    private Date recordedDate;
    private String currency;
    private Boolean recurring;
    private Date updateDate;
}
