package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("========================== Mobile Phone ===================================");
	    MobilePhone sparrowPhone = new MobilePhone("1234567");
        Contact stew = new Contact("Stew", "1231111");
        Contact crew = new Contact("Crew", "1231112");
        Contact blue = new Contact("Blue", "1231113");
        sparrowPhone.addNewContact(stew);
        sparrowPhone.addNewContact(crew);
        sparrowPhone.addNewContact(blue);
        sparrowPhone.printContacts();
        sparrowPhone.addNewContact(new Contact("Stew", "1231111")); // Should be an error already exists

        System.out.println("========================== Bank ===================================");
        Bank bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");
        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);
        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
        System.out.println("========================= when TRUE =============================");
        bank.listCustomers("Adelaide", true);
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Transactions
//                [1] Amount 50.05
//                [2] Amount 44.22
//                [3] Amount 12.44
//        Customer: Mike[2]
//        Transactions
//                [1] Amount 175.34
//                [2] Amount 1.65
//        Customer: Percy[3]
//        Transactions
//                [1] Amount 220.12
        System.out.println("========================= when false =============================");
        bank.listCustomers("Adelaide", false);
//        Customer details for branch Adelaide
//        Customer: Tim[1]
//        Customer: Mike[2]
//        Customer: Percy[3]
    }
}
