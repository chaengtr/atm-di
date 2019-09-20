package atm_spring_jdbc.db;

import atm_spring_jdbc.atm.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSourceDaoImp implements DataSourceDao {
    private JdbcTemplate jdbcTemplate;

    public DataSourceDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<Integer, Customer> findAll() {
        String query = "SELECT * FROM customer";
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
        List<Customer> customerList = jdbcTemplate.query(query, new DaraSourceRowMapper());
        for (Customer c : customerList) {
            customers.put(c.getCustomerNumber(), c);
        }
        return customers;
    }

    private class DaraSourceRowMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer(resultSet.getInt(1),
                    resultSet.getInt(2), resultSet.getDouble(3));
            return customer;
        }
    }
}
