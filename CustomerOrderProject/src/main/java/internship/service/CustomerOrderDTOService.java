package internship.service;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;

import java.util.List;


public interface CustomerOrderDTOService {
    CustomerOrderDTO getDTO(Customer customer, List<Order> list);
}