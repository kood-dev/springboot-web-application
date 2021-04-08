package com.kooddev.domain.customer.domain;

import com.kooddev.domain.customer.domain.type.YNType;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class CustomerRefundAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long refundId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;

    private String bankCode;
    private String account;
    private String holder;

    @Enumerated(EnumType.STRING)
    private YNType defaultYn = YNType.N;
}
