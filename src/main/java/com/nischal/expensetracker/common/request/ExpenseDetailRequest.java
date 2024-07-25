package com.nischal.expensetracker.common.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
public class ExpenseDetailRequest implements Serializable {

    @NotBlank(message = "Please Enter description.")
    private String description;

    @Positive(message = "Please enter a positive number.")
    private Double amount;

    private String currency = "NPR.";

    @NotNull
    private Boolean recurring;

    private Long categoryId;

}
