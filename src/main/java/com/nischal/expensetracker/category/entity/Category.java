package com.nischal.expensetracker.category.entity;

import com.nischal.expensetracker.common.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@Entity
public class Category extends BaseEntity {

    private String name;
    private String description;
    private Date recordedDate;
}
