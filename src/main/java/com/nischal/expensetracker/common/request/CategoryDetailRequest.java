package com.nischal.expensetracker.common.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Nischal on 7/23/2024
 */

@Getter
@Setter
public class CategoryDetailRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
