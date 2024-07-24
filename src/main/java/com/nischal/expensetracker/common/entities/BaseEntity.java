package com.nischal.expensetracker.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;


/**
 * @Author : Nischal on 7/20/2024
 */

@Getter
@Setter
@MappedSuperclass
@RequiredArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Generated(GenerationTime.INSERT)
    @Column(name = "status", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    protected Boolean status;
}
