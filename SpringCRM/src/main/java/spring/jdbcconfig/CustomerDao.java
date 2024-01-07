package spring.jdbcconfig;

import springcrm.data.Customer;

import java.util.List;

public interface CustomerDao {
    public int insert(Customer customer);

    public int update(Customer customer);

    public int delete(int id);

    public List<Customer> getData();

    public Customer getCustomer(int id);
}
