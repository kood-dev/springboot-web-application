package com.kooddev.domain.customer.domain;

import com.kooddev.domain.customer.domain.type.CustomerStatusType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    Customer customer;

    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .username("kood.d2v@gmail.com")
                .email("kood.d2v@gmail.com")
                .password("암호화 필요")
                .mobile("010-1111-1111")
                .name("kood.d2v")
                .status(CustomerStatusType.Normal)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("회원 등록 후 조회 테스트")
    @Test
    public void 회원_등록_테스트() {
        // given
        customerRepository.save(customer);

        // whenf
        Customer saveCustomer = customerRepository.findByUsername(customer.getUsername()).orElse(Customer.builder().build());

        //then
        assertEquals(customer.getName(), saveCustomer.getName());
    }
}