package internship.service.test;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import internship.service.CustomerOrderDTOServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;



@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerOrderDTOServiceImplTest {

    @Mock
    private CustomerOrderDTOServiceImpl customerOrderDTOService;
    private Customer customer;
    private Order order;

    @Before
    public void setup() {
        customerOrderDTOService = new CustomerOrderDTOServiceImpl();
        customer = new Customer();
        order = new Order();
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();


        Mockito.when(customerOrderDTOService.getDTO(customer, Collections.singletonList(order))).thenReturn(customerOrderDTO);
    }

    @Test
    public void getDTOIfPresent(){

        CustomerOrderDTO result = customerOrderDTOService.getDTO(customer, Collections.singletonList(order));
        Assert.assertNotNull(result);
    }

    @Test
    public void getDTOIfMissing(){
        Mockito.when(customerOrderDTOService.getDTO(customer, Collections.singletonList(order))).thenReturn(null);
        CustomerOrderDTO result = customerOrderDTOService.getDTO(customer, Collections.singletonList(order));
        Assert.assertNull(result);
    }
}
