package com.nischal.expensetracker.category.entity;

import com.nischal.expensetracker.common.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@Entity
public class Category extends BaseEntity {

    private String name;
    private String description;
}
