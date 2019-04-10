package internship.service;

import internship.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(Integer id);
}
