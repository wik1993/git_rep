package internship.service;

import internship.model.Customer;
import internship.model.Order;
import internship.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> findCustomerOrders(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }

    @Override
    public void addOrder(Order order) {
         orderRepository.save(order);
    }

}
