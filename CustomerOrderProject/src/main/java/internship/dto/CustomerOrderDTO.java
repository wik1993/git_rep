package internship.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.xml.internal.ws.developer.Serialization;
import internship.model.Customer;
import internship.model.Order;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;
import java.util.List;


public class CustomerOrderDTO{

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("orderList")
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
