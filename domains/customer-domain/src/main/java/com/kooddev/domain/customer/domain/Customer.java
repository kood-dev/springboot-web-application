package com.kooddev.domain.customer.domain;

import com.kooddev.domain.customer.domain.type.CustomerStatusType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * @author gwkoo
 * @date 2021.04.07
 */
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;

    @Column(unique = true)
    private String username;

    @Column
    private String email;

    @Column(length = 512)
    private String password;

    @Column
    private String name;

    @Column
    private String mobile;

    @Enumerated(EnumType.STRING)
    @Column
    private CustomerStatusType status;

    @Builder
    public Customer(String username, String email, String password, String name, String mobile, CustomerStatusType status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.status = status;
    }
}
