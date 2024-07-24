package com.nischal.expensetracker.budget.entities;

import com.nischal.expensetracker.common.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@Entity
public class Budget extends BaseEntity {

    private Double amount;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
}
