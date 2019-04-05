package internship.service;

import internship.service.CustomerService;
import internship.model.Customer;
import internship.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
