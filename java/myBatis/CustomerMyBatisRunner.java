package myBatis;

import mapper.CustomerMapperJava;
import model.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomerMyBatisRunner {
    public static void main(String[] args) throws IOException {

        //Open Session for use with Interface and annotations.
        try (InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            CustomerMapperJava customerMapperJava = session.getMapper(CustomerMapperJava.class);

            //getAllCustomers using Interface and annotations
             List<Customer> customerList =  customerMapperJava.getAllCustomers();
             System.out.println(customerList);

            //Get event by id using Interface and annotations
             //Customer customer = customerMapperJava.getById(1);
             //System.out.println("Customer with Interface:\n" + customer);


            //UPDATE customer using Interface and annotations
            /*Customer customer = customerMapperJava.getById(1);
            System.out.println("Current customer :  "+ customer);

            //Update eventName
            customer.setCustomerPhone("123-123-1234");

            //Update the event record using Interface and annotations
            customerMapperJava.update(customer);
            System.out.println("Record updated successfully" );
            session.commit();

            //Show the updated record
            Customer customer1 = customerMapperJava.getById(1);
            System.out.println(customer1);*/


            //Insert using Interface and annotations
           /* Customer customer= new Customer();
            customer.setCustomerName("Elaine");
            customer.setCustomerPhone("333-333-3333");
            customer.setCustomerStreetAddress("Page Creek Blvd");
            customer.setCityId(1);

            customerMapperJava.insert(customer);
            System.out.println("Inserted customer:\n" + customer);
            session.commit();*/

        }
    }
}
