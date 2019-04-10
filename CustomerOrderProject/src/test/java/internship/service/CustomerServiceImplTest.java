package internship.service;

import internship.model.Customer;
import internship.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    private CustomerServiceImpl service;
    private Customer customer;

    @Before
    public void setup() {
        service = new CustomerServiceImpl(repository);
        customer = new Customer();

        Mockito.when(repository.findById(1)).thenReturn(Optional.of(customer));
        Mockito.when(repository.findById(2)).thenReturn(Optional.empty());
    }

    @Test
    public void addCustomerTest() {

        service.addCustomer(customer);
        Mockito.verify(repository).save(customer);
    }

    @Test
    public void findCustomerByIdTestForCustomer() {

        Optional<Customer> result = service.findCustomerById(1);
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void findCustomerByIdTestForMissingCustomer() {

        Optional<Customer> result = service.findCustomerById(2);
        Assert.assertFalse(result.isPresent());
    }

}
