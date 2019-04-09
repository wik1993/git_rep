package internship.controller;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import internship.service.CustomerOrderDTOService;
import internship.service.CustomerService;
import internship.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private CustomerOrderDTOService customerOrderDTOService;

    @GetMapping(path = "/customerId/{id}")
    public @ResponseBody CustomerOrderDTO findCustomerOrders(@PathVariable("id") Integer id){
        Customer customer = customerService.findCustomerById(id).orElse(null);
        List<Order> orderList = (List<Order>) orderService.findCustomerOrders(customer);
        return customerOrderDTOService.getDTO(customer, orderList);
    }

    @PostMapping(path = "/add/{id}")
    public @ResponseBody
    ResponseEntity addOrderForCustomer(@PathVariable ("id") Integer id, @RequestBody Order order) {
        try {
            Customer customer = customerService.findCustomerById(id).orElse(null);
            order.setCustomer(customer);
            orderService.addOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
