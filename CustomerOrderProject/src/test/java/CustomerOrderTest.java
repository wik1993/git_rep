import internship.dto.CustomerOrderDTO;
import internship.model.Customer;
import internship.model.Order;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class CustomerOrderTest extends AbstractTest {

    @Test
    public void getCustomerTest() throws Exception {
       String uri = "/customer/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Customer[] customers = super.mapFromJson(content, Customer[].class);
        assertEquals(200, status);
        assertTrue(customers.length > 0);
    }

    @Test
    public void createCustomer() throws Exception {
        String uri = "/customer/add";
        Customer customer = new Customer();
        customer.setName("Petea");
        customer.setEmail("asdsad@gmail.com");

        String inputJson = super.mapToJson(customer);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void createOrderForCustomer() throws Exception {
        String uri = "/order/add/3";
        Order order = new Order();
        order.setPrice(50);
        order.setDate("22/12/2020");
        String inputJson = super.mapToJson(order);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    public void getCustomerWithOrders() throws Exception {
        String uri = "/order/customerId/8";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        CustomerOrderDTO customerOrderDTOS = super.mapFromJson(content, CustomerOrderDTO.class);
        assertNotNull(customerOrderDTOS);
        assertEquals(200, status);
    }
}
