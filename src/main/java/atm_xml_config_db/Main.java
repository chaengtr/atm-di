package atm_xml_config_db;

import atm_xml_config_db.atm.ATMSimulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config-db.xml");
        ATMSimulator atmSimulator = context.getBean("atmSimulator", ATMSimulator.class);
        atmSimulator.run();
    }
}
