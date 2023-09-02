package json;

import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CustomerMain {

    public static void main(String [] args) {

        File customerFile = new File("C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\customer.json");

        CustomerJson customer = new CustomerJson();
        customer.setCustomerName("Lynn Weidman");
        customer.setCustomerPhone("111-111-1111");
        customer.setCustomerId(30);
        customer.setCustomerStreetAddress("1 Oak St.");

        CustomerJson customer2 = new CustomerJson();
        customer2.setCustomerName("Luke Weidman");
        customer2.setCustomerPhone("555-555-5555");


        List<CustomerJson> listCustomers = new ArrayList<>();
        listCustomers.add(customer);
        listCustomers.add(customer2);

        System.out.println("Ticket list: " + listCustomers);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Serialize customer Object to String
            String serializeCustomer = objectMapper.writeValueAsString(customer);
            System.out.println("Serialized customer  " + serializeCustomer);
            String getNameOnly = objectMapper.writeValueAsString(customer.getCustomerName());

            System.out.println("Print customer name only- " + getNameOnly);

            //Deserialize String customer to Object
            CustomerJson deserializeCustomer = objectMapper.readValue(serializeCustomer, CustomerJson.class);
             System.out.println("DeserializedCustomer " + deserializeCustomer);

            //Serialize listCustomer Object to String
            String stringList = objectMapper.writeValueAsString(listCustomers);
            System.out.println("Serialized list- " + stringList);

            //Find out if element is in the list T/F

            String isThisOnTheList = objectMapper.writeValueAsString(stringList.contains("Lynn"));
            System.out.println("Is Lynn on the list?   " + isThisOnTheList);

            //Write to the file
            objectMapper.writeValue(customerFile, serializeCustomer);
            objectMapper.writeValue(customerFile, stringList);


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
