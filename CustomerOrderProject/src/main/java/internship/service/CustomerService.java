package internship.service;

import internship.model.Customer;

public interface CustomerService {
    void addCustomer(Customer customer);
    Iterable<Customer> findAllCustomers();
}
