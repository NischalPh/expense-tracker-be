package com.nischal.expensetracker.common.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nischal.expensetracker.common.enums.GenderType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Collections;

/**
 * @Author : Nischal on 7/25/2024
 */

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(length = 150, name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(length = 150, name = "MIDDLENAME")
    private String middleName;

    @Column(length = 150, name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "GENDER", columnDefinition = "enum('MALE','FEMALE')", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @Column(length = 150, name = "address", nullable = false)
    private String address;

    @JsonIgnore
    @Column(length = 20, name = "contact_no", nullable = false)
    private String contactNo;

    @JsonIgnore
    @Column(length = 150, name = "email_address", nullable = false)
    private String emailAddress;

    @JsonIgnore
    @Column(length = 150, name = "password", nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return getStatus();
    }
}
