package internship.service.test;

import internship.model.Customer;
import internship.repository.CustomerRepository;
import internship.service.CustomerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        Customer result = service.findById(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findCustomerByIdTestForMissingCustomer() {
        Customer result = service.findById(2);
        Assert.assertNull(result);
    }

    @Test
    public void findAllCustomersIfCustomersExist(){
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(customer));
        List list = service.findAllCustomers();
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(customer, list.get(0));
    }

    @Test
    public void findAllCustomersIfCustomersAreMissing(){
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());
        List list = service.findAllCustomers();
        Assert.assertTrue(list.isEmpty());
    }
}
