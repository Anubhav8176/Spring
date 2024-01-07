package spring.jdbcconfig;


import org.springframework.jdbc.core.JdbcTemplate;
import springcrm.data.Customer;

import java.util.List;

public class CustomerDaoImple implements CustomerDao {

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Customer customer) {
        String query = "insert into customer(c_id, name, email) values(?,?,?)";
        jdbcTemplate.update(query, customer.getC_id(), customer.getName(), customer.getEmail());
        return 0;
    }

    @Override
    public int update(Customer customer) {
        String query = "update customer set name=?, email=? where c_id=?";
        jdbcTemplate.update(query, customer.getName(), customer.getEmail(), customer.getC_id());
        return 0;
    }

    @Override
    public int delete(int id) {
        String query = "delete from customer where c_id=?";
        jdbcTemplate.update(query, id);
        return 0;
    }

    @Override
    public List<Customer> getData() {
        String query = "select * from customer";
        return this.jdbcTemplate.query(query, new RowMapperImple());
    }

    @Override
    public Customer getCustomer(int id) {
        String query = "select * from customer where c_id=?";
        Customer newC = this.jdbcTemplate.queryForObject(query, new RowMapperImple(), id);
        return newC;
    }

}
