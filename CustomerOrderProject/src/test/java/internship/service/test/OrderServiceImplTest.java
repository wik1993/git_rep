package internship.service.test;

import internship.model.Customer;
import internship.model.Order;
import internship.repository.OrderRepository;
import internship.service.OrderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;
    private OrderServiceImpl orderService;
    private Order order;
    private Customer customer;
    private Customer customer1;

    @Before
    public void setup(){
        orderService = new OrderServiceImpl(orderRepository);
        order = new Order();
        customer = new Customer();
        customer1 = new Customer();

        Mockito.when(orderRepository.findAllByCustomer(customer)).thenReturn(Collections.singletonList(order));
        Mockito.when(orderRepository.findAllByCustomer(customer1)).thenReturn(new ArrayList<>());
    }

    @Test
    public void addOrderTest(){
        orderService.addOrder(order);
        Mockito.verify(orderRepository).save(order);
    }

    @Test
    public void findCustomerOrdersIfExists(){
        List list = orderService.findCustomerOrders(customer);
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(order, list.get(0));
    }

    @Test
    public void findCustomerOrdersIfIsEmpty(){
        List list = orderService.findCustomerOrders(customer1);
        Assert.assertTrue(list.isEmpty());
    }
}
