/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.home.gearrentpro.service;

import main.java.com.home.gearrentpro.dao.CustomerDAO;
import main.java.com.home.gearrentpro.model.Customer;

/**
 *
 * @author Dell
 */
public class CustomerService {
    
     private static final double MAX_DEPOSIT_LIMIT = 500000;

    private final CustomerDAO customerDAO = new CustomerDAO();

    public void addCustomer(Customer customer) throws Exception {
        customerDAO.insert(customer);
    }

    public void validateDepositLimit(int customerId, double newDeposit)
            throws Exception {

        double currentDeposit =
                customerDAO.getActiveDepositTotal(customerId);

        if (currentDeposit + newDeposit > MAX_DEPOSIT_LIMIT) {
            throw new RuntimeException(
                    "Security deposit limit exceeded"
            );
        }
    }
}
