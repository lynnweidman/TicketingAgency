package utils;

import model.Customer;
import java.util.List;

public interface CustomerInterface {
    public List<Customer> getAllCustomers();
    public Customer getCustomer(int customerId);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(int customerId);
}
