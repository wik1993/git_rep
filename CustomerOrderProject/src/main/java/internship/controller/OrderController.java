package internship.controller;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import internship.service.CustomerService;
import internship.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Optional<Customer> customer = customerService.findCustomerById(id);
        List<Order> orderList = (List<Order>) orderService.findCustomerOrders(customer);

        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
        customerOrderDTO.setCustomer(customer);
        customerOrderDTO.setOrderList(orderList);

        return customerOrderDTO;
    }
}
