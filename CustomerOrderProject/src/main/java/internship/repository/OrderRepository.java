package internship.repository;

import internship.model.Customer;
import internship.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository <Order, Integer> {
    List<Order> findAllByCustomer(Customer customer);
}
