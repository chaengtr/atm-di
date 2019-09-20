package atm_spring_jdbc.atm;

import atm_spring_jdbc.db.DataSourceDaoImp;

import java.util.Map;

public class DataSource {

    private DataSourceDaoImp dataSource;

    public DataSource(DataSourceDaoImp dataSource) {
        this.dataSource = dataSource;
    }

    public Map<Integer, Customer> readCustomers() {
        Map<Integer, Customer> customers = dataSource.findAll();
        return customers;
    }
}
