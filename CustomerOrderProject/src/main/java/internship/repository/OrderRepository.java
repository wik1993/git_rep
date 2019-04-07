package internship.repository;

import internship.model.Customer;
import internship.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Integer> {
    Iterable<Order> findAllByCustomer(Customer customer);
}
