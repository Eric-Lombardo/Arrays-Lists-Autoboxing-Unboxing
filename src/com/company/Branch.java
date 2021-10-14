package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customer, double transaction) {
        // Returns true if the customer was added successfully or false otherwise.
        if (findCustomer(customer) == null) {
            Customer newCustomer = new Customer(customer, transaction);
            this.customers.add(newCustomer);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customer, double transaction) {
        // Returns true if the customers transaction was added successfully or false otherwise.
        Customer targetCustomer = findCustomer(customer);
        if (targetCustomer == null) {
            return false;
        } else {
            targetCustomer.addTransaction(transaction);
            return true;
        }
    }

    private Customer findCustomer(String customer) {
        // Return the Customer if they exist, null otherwise.
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customer)) {
                return customers.get(i);
            }
        }
        return null;
    }
}
