package com.nischal.expensetracker.expense.entity;

import com.nischal.expensetracker.category.entity.Category;
import com.nischal.expensetracker.common.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@Entity
public class Expense extends BaseEntity {

    private String description;
    private Double amount;
    private Date recordedDate;
    private String currency;
    private Boolean recurring;
    private Date updateDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category")
    private Category category;
}
