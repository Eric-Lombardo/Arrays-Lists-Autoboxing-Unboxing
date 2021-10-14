package com.company;

import java.util.ArrayList;

public class Bank {
//    Your job is to create a simple banking application.
//    Implement the following classes:
//
//    1. Bank
//    -It has two fields, A String called name and an ArrayList that holds objects of type Branch called branches.
//    -A constructor that takes a String (name of the bank). It initialises name and instantiates branches.
//    -And five methods, they are (their functions are in their names):
//    - addBranch(), has one parameter of type String (name of the branch) and returns a boolean. It returns true if the
//      branch was added successfully or false otherwise.
//    -addCustomer(), has three parameters of type String (name of the branch), String (name of the customer), double
//      (initial transaction) and returns a boolean. It returns true if the customer was added successfully or false otherwise.
//    - addCustomerTransaction(), has three parameters of type String (name of the branch), String (name of the
//      customer), double (transaction) and returns a boolean. It returns true if the customers transaction was added
//      successfully or false otherwise.
//    - findBranch(), has one parameter of type String (name of the Branch) and returns a Branch. Return the Branch if
//      it exists or null otherwise.
//    -listCustomers(), has two parameters of type String (name of the Branch), boolean (print transactions) and returns
//      a boolean. Return true if the branch exists or false otherwise. This method prints out a list of customers.
//
//    2. Branch
//    - It has two fields, A String called name and an ArrayList that holds objects of type Customer called customers.
//    - A constructor that takes a String (name of the branch). It initialises name and instantiates customers.
//    -And five methods, they are (their functions are in their names):
//    - getName(), getter for name.
//    - getCustomers(), getter for customers.
//    - newCustomer(), has two parameters of type String (name of customer), double (initial transaction) and returns
//      a boolean. Returns true if the customer was added successfully or false otherwise.
//    - addCustomerTransaction(), has two parameters of type String (name of customer), double (transaction) and returns
//      a boolean. Returns true if the customers transaction was added successfully or false otherwise.
//    - findCustomer(), has one parameter of type String (name of customer) and returns a Customer. Return the Customer
//      if they exist, null otherwise.
//
//    3. Customer
//    - It has two fields, A String called name and an ArrayList that holds objects of type Double called transactions.
//    - A constructor that takes a String (name of customer) and a double (initial transaction). It initialises
//      name and instantiates transactions.
//    - And three methods, they are (their functions are in their names):
//    - getName(), getter for name.
//    - getTransactions(), getter for transactions.
//    - addTransaction(), has one parameter of type double (transaction) and doesn't return anything.

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branch) {
        // It returns true if the branch was added successfully or false otherwise.
        if (findBranch(branch) == null) {
            Branch newBranch = new Branch(branch);
            branches.add(newBranch);
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        // It returns true if the customer was added successfully or false otherwise.
        Branch targetBranch = findBranch(branchName);
        ArrayList<Customer> targetBranchCustomers = targetBranch != null ? targetBranch.getCustomers() : null;

        if (targetBranchCustomers != null) {
            for (int i = 0; i < targetBranchCustomers.size(); i++) {
                if (targetBranchCustomers.get(i).getName().equals(customerName)) {
                    return false;
                }
            }
        }

        if (targetBranch == null) {
            return false;
        } else {
            targetBranch.newCustomer(customerName, transaction);
            return true;
        }
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        // It returns true if the customers transaction was added successfully or false otherwise.
        Branch targetBranch = findBranch(branchName);
        ArrayList<Customer> targetBranchCustomers = targetBranch != null ? targetBranch.getCustomers() : null;

        if (targetBranchCustomers != null) {
            for (int i = 0; i < targetBranchCustomers.size(); i++) {
                if (targetBranchCustomers.get(i).getName().equals(customerName)) {
                    targetBranch.addCustomerTransaction(customerName, transaction);
                    return true;
                }
            }
        }
        return false;
    }

    private Branch findBranch(String branch) {
        // Return the Branch if it exists or null otherwise
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branch)) {
                return branches.get(i);
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        // Return true if the branch exists or false otherwise. This method prints out a list of customers.
        Branch targetBranch = findBranch(branchName);
        if (targetBranch != null) {
            ArrayList<Customer> targetBranchCustomers = targetBranch.getCustomers();
            System.out.println("Customer details for branch " + branchName);
            for (int i = 0; i < targetBranchCustomers.size(); i++) {
                System.out.println("Customer: " + targetBranchCustomers.get(i).getName() + "[" + (i+1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    for (int j = 0; j < targetBranchCustomers.get(i).getTransactions().size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + targetBranchCustomers.get(i).getTransactions().get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
