package com.company;

public class Main {

    public static void main(String[] args) {
	    MobilePhone sparrowPhone = new MobilePhone("1234567");
        Contact stew = new Contact("Stew", "1231111");
        Contact crew = new Contact("Crew", "1231112");
        Contact blue = new Contact("Blue", "1231113");

        sparrowPhone.addNewContact(stew);
        sparrowPhone.addNewContact(crew);
        sparrowPhone.addNewContact(blue);
        sparrowPhone.printContacts();
        sparrowPhone.addNewContact(new Contact("Stew", "1231111")); // Should be an error already exists
    }
}
