package internship.service;

import internship.model.Customer;
import internship.model.Order;

public interface OrderService {
    Iterable<Order> findAllOrders();

    Iterable<Order> findCustomerOrders(Customer customer);
}
