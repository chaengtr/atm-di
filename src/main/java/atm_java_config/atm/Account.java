package atm_java_config.atm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 */
public class Account {
   private double balance;

   /**
    * Constructs a bank account with a zero balance.
    */
   public Account() {
      balance = 0;
   }

   /**
    * Constructs a bank account with a given balance.
    * @param initialBalance the initial balance
    */
   public Account(double initialBalance) {
      balance = initialBalance;
   }
 
   /** 
    * Deposits money into the account.
    * @param amount the amount of money to withdraw
    */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /** 
    * Withdraws money from the account.
    * @param amount the amount of money to deposit
    */
   public void withdraw(double amount) {
      balance = balance - amount;
   }

   /** 
    * Gets the account balance.
    * @return the account balance
    */
   public double getBalance() {
      return balance; 
   }

   /**
    * A bank contains customers with bank accounts.
    */
   public static class Bank {

      private Map<Integer, Customer> customers;
      private DataSource dataSource;

      /**
       * Constructs a bank with no customers.
       */
      public Bank(DataSource dataSource) {
         this.dataSource = dataSource;
         customers = new HashMap<Integer,Customer>();
      }

      public void initializeCustomers() throws IOException {
         customers = dataSource.readCustomers();
      }
      /**
       * Adds a customer to the bank.
       * @param c the customer to add
       */
      public void addCustomer(Customer c) {
         customers.put(c.getCustomerNumber(), c);
      }

      /**
       * Finds a customer in the bank.
       * @param number a customer number
       * @return the matching customer, or null if no customer
       * matches
       */
      public Customer findCustomer(int number) {
        return customers.get(number);
      }
   }
}

