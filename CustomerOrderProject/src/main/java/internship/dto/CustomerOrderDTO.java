package internship.dto;

import internship.model.Customer;
import internship.model.Order;
import java.util.List;


public class CustomerOrderDTO {

    private List<Order> orderList;

    private Customer customer;


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
