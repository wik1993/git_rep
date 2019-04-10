package internship.service;

import internship.model.Customer;
import internship.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findCustomerOrders(Customer customer);

    void addOrder (Order order);
}
