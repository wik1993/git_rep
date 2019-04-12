package internship.service;

import internship.model.Customer;
import internship.model.Order;
import internship.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findCustomerOrders(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }

    @Override
    public void addOrder(Order order) {
         orderRepository.save(order);
    }

}
