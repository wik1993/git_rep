package internship.controller;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import internship.service.CustomerService;
import internship.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping(path = "/order")
public class OrderController  {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Order> findAllOrders(){
       return orderService.findAllOrders();
    }

    @GetMapping(path = "/customerId/{id}")
    public @ResponseBody CustomerOrderDTO findCustomerOrders(@PathVariable("id") Integer id){
        Customer customer = customerService.findCustomerById(id).orElse(null);
        List<Order> orderList = (List<Order>) orderService.findCustomerOrders(customer);
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
        customerOrderDTO.setCustomer(customer);
        customerOrderDTO.setOrderList(orderList);
        return customerOrderDTO;
    }

    @PostMapping(path = "/add/{id}")
    public @ResponseBody void addOrderForCustomer(@PathVariable ("id") Integer id,@RequestBody Order order) {
        Customer customer = customerService.findCustomerById(id).orElse(null);
        order.setCustomer(customer);
        orderService.addOrder(order);
    }
}
