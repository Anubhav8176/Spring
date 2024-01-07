package spring.jdbcconfig;

import org.springframework.jdbc.core.RowMapper;
import springcrm.data.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImple implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setC_id(rs.getInt(1));
        customer.setName(rs.getString(2));
        customer.setEmail(rs.getString(3));
        return customer;
    }
}
