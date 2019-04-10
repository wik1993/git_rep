package internship.service;

import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderDTOServiceImpl implements  CustomerOrdersDTOService{
    @Override
    public CustomerOrderDTO getDTO(Customer customer, List<Order> list) {
        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();
        customerOrderDTO.setCustomer(customer);
        customerOrderDTO.setOrderList(list);
        return customerOrderDTO;
    }
}
