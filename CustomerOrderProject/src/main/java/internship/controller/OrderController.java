package internship.controller;
import internship.model.Customer;
import internship.model.Order;
import internship.service.CustomerOrdersDTOService;
import internship.service.CustomerService;
import internship.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
@RequestMapping(path = "/order")
public class OrderController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrdersDTOService customerOrderDTOService;

    @GetMapping(path = "/customerId/{id}")
    public @ResponseBody
    ResponseEntity findCustomerOrders(@PathVariable("id") Integer id){
        LOGGER.debug("Fetching customer's orders");
        Customer customer = customerService.findById(id);
        List<Order> orderList = orderService.findCustomerOrders(customer);
        return new ResponseEntity<>(customerOrderDTOService.getDTO(customer, orderList), HttpStatus.OK);
    }

    @PostMapping(path = "/add/{id}")
    public @ResponseBody
    ResponseEntity addOrderForCustomer(@PathVariable ("id") Integer id, @RequestBody Order order) {
        LOGGER.debug("Adding Order for a customer");
        try {
            Customer customer = customerService.findById(id);
            order.setCustomer(customer);
            orderService.addOrder(order);
        } catch (Exception e) {
            LOGGER.error("Error occurred when adding order", e);
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
