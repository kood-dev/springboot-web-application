package kr.co.hellonature.core.model.customer;

import kr.co.hellonature.core.model.customer.type.CustomerStatusType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @Column
    private String connectInformation;

    @Enumerated(EnumType.STRING)
    @Column
    private CustomerStatusType status;

}
