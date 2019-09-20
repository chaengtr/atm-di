package atm_spring_jdbc.db;

import atm_spring_jdbc.atm.Customer;
import java.util.Map;

public interface DataSourceDao {
    Map<Integer, Customer> findAll();
}
