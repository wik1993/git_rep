package internship.controller;

import internship.model.Customer;
import internship.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addCustomer(@RequestBody Customer customer){
        LOGGER.debug("Start adding a customer");
        try {
            customerService.addCustomer(customer);
            LOGGER.info("Customer is added to database");
        } catch (Exception e) {
            LOGGER.error("Error occurred when adding customer", e);
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity findAllCustomers(){
        LOGGER.debug("Fetching customers from database");
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }

}
