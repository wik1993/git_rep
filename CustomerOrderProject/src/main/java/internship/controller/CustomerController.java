package internship.controller;

import internship.model.Customer;
import internship.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add")
    public @ResponseBody
    ResponseEntity addCustomer(@RequestBody Customer customer){
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

}
