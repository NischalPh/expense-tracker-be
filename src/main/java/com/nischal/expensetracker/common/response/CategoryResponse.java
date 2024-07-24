package com.nischal.expensetracker.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Nischal on 7/23/2024
 */

@Getter
@Setter
public class CategoryResponse {

    private Long id;
    private String name;
    private String description;
}
