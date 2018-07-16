package com.cfd.member.service.impl;

import com.cfd.member.service.CustomerService;
import com.cfd.pojo.mo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static org.springframework.test.util.AssertionErrors.*;

/**
 * @auth snifferhu
 * @date 2018/7/15 17:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private CustomerService customerService;

    @Test
    public void queryByUserName() throws Exception {
        List<Customer> customerList = customerService.queryByUserName("sniff");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        assertTrue("queryByUserName fail.params sniff", customerList.size() == 1);
    }

    @Test
    public void queryById() throws Exception {
        Optional<Customer> customer = customerService.queryById("5b4b1c535797e1260e8693ce");
        System.out.println(customer.get());
        assertTrue("queryById fail.params 5b4b1c535797e1260e8693ce", customer.isPresent());
    }

    @Test
    public void deleteById() throws Exception {
        customerService.deleteById("5b4b1c745797e1261a93ded2");
    }

    @Test
    public void disableByUserName() throws Exception {
        long flag = customerService.disableByUserName("sniff");
        Optional<Customer> customer = customerService.queryById("5b4b1c535797e1260e8693ce");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.param sniff", flag == 1);
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Customer()).getStatus() == 1);
    }

    @Test
    public void existsById() throws Exception {
        assertTrue("existsById fail.params 5b4b1c535797e1260e8693ce", customerService.existsById("5b4b1c535797e1260e8693ce"));
        assertFalse("existsById fail.params 5b4b1c535797e1260e8693ce", customerService.existsById("1"));
    }

    @Test
    public void enableById() throws Exception {
        customerService.enableById("5b4b1c535797e1260e8693ce");
        Optional<Customer> customer = customerService.queryById("5b4b1c535797e1260e8693ce");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Customer()).getStatus() == 0);
    }

    @Test
    public void enableByUserName() throws Exception {
        customerService.enableByUserName("sniff");
        Optional<Customer> customer = customerService.queryById("5b4b1c535797e1260e8693ce");
        System.out.println(customer.get());
        assertTrue("disableByUserName fail.params sniff", customer.orElse(new Customer()).getStatus() == 0);
    }

    @Test
    public void insert() throws Exception {
        Customer customer = Customer.createByUserName("sniff");
        customer.setPassword("123456");
        Customer result = customerService.insert(customer);
        assertTrue("password check fail", passwordEncoder.matches("123456", result.getPassword()));
        assertEquals("insert fail", customer.getUserName(), result.getUserName());
        System.out.println(customer.getId());
    }

}