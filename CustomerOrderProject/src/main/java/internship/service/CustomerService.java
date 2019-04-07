package internship.service;

import internship.model.Customer;

import java.util.Optional;

public interface CustomerService {
    void addCustomer(Customer customer);
    Iterable<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(Integer id);
}
