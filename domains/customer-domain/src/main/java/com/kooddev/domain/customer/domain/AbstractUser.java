package com.kooddev.domain.customer.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class AbstractUser {

    @Column(unique = true)
    private String username;
    @Column
    private String email;
    @Column(length = 512)
    private String password;
}
