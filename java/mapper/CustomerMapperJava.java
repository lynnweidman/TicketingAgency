package mapper;

import model.Customer;
import model.Venue;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapperJava {
    final String getAll = "SELECT * FROM customers";
    final String getById = "SELECT * FROM customers WHERE customer_id = #{customerId}";
    final String deleteById = "DELETE from customers WHERE customer_id = #{customerId}";
    final String insert = "INSERT INTO customers (customer_name, customer_phone, customer_street_address, city_Id ) VALUES (#{customerName},#{customerPhone}, #{customerStreetAddress}, #{cityId})";
    final String update = "UPDATE customers SET customer_name = #{customerName}, customer_phone = #{customerPhone}, customer_street_address = #{customerStreetAddress}, city_id = #{cityId} WHERE customer_id = #{customerId}";


    @Select(getAll)
    @Results(value = {
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "customerName", column = "customer_name"),
            @Result(property = "customerPhone", column = "customer_phone"),
            @Result(property = "customerStreetAddress", column = "customer_street_address"),
            @Result(property = "cityId", column = "city_id")

    })
    public List<Customer> getAllCustomers();

    @Select(getById)
    @Results(value = {
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "customerName", column = "customer_name"),
            @Result(property = "customerPhone", column = "customer_phone"),
            @Result(property = "customerStreetAddress", column = "customer_street_address"),
            @Result(property = "cityId", column = "city_id")
    })

    Customer getById(int customerId);

    @Update(update)
    void update(Customer customer);

    @Delete(deleteById)
    void delete(int customerId);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "customerId")
    void insert(Customer customer);

}
