package internship.dto;

import internship.model.Customer;
import internship.model.Order;
import java.util.List;


public class CustomerOrderDTO {

    private Customer customer;

    private List<Order> orderList;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
