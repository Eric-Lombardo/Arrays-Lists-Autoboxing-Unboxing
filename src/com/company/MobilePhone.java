package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class MobilePhone {
//    Create a program that implements a simple mobile phone with the following capabilities.
//        1. Implement the master class MobilePhone, that holds the ArrayList of Contacts, with the following attributes:
//            -Two fields, a String called myNumber and an ArrayList of type Contact called myContacts.
//            -A constructor that takes a String (the phone number) and initialises myNumber and instantiates myContacts.
//            - And seven methods, they are (their functions are in their names):
//            - addNewContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact
//              doesn't exists, or false if the contact already exists.
//            - updateContact(), has two parameters of type Contact (the old contact that will be updated with the new
//              contact) and returns a boolean. Returns true if the contact exists and was updated successfully, or
//                  false if the contact doesn't exists.
//            - removeContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact
//              exists and was removed successfully, or false if the contact doesn't exists.
//            -findContact(), has one parameter of type Contact and returns an int. The returned value is it's position
//              in the ArrayList, it will either be -1 (doesn't exists) or a value greater than or equal to 0 (does exists).
//            - findContact(), same as above, only it has one parameter of type String.
//            - queryContact(), has one parameter of type String and returns a Contact. Use the String to search for
//              the name and then return the Contact. Return null otherwise.
//            - printContacts(), has no parameters and doesn't return anything. Print the contacts in the following format:
//
//    Contact List:
//            1. Bob -> 31415926
//            2. Alice -> 16180339
//            3. Tom -> 11235813
//            4. Jane -> 23571113
//
//        2. Implement the Contact class with the following attributes:
//            - Two fields, both String, one called name and the other phoneNumber.
//            - A constructor that takes two Strings, and initialises name and phoneNumber.
//            - And Three methods, they are:
//            - getName(), getter for name.
//            - getPhoneNumber(), getter for phoneNumber.
//            -createContact(), has two parameters of type String (the persons name and phone number) and returns an
//              instance of Contact. This is the only method that is static.

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        boolean foundMatch = false;

        for (int i = 0; i < myContacts.size(); i++) {
            if (Objects.equals(myContacts.get(i).getName(), contact.getName())) {
                foundMatch = true;
                break;
            }
        }

        if (foundMatch) {
            System.out.println(contact.getName() + " Contact already exists");
            return false;
        } else {
            System.out.println("Adding new contact: " + contact.getName() + " " + contact.getPhoneNumber());
            myContacts.add(contact);
            return true;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int indexOfOldContact = findContact(oldContact);
        if (indexOfOldContact >= 0) {
            myContacts.set(indexOfOldContact, newContact);
            System.out.println("Updated contact successfully");
            return true;
        } else {
            System.out.println("That contact does not exist, sorry.");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        int indexOfOldContact = findContact(contact);
        if (indexOfOldContact >= 0) {
            myContacts.remove(indexOfOldContact);
            System.out.println("Contact removed successfully");
            return true;
        } else {
            System.out.println("That contact does not exist. Unable to delete, sorry.");
            return false;
        }
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (Objects.equals(myContacts.get(i).getName(), contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (Objects.equals(myContacts.get(i).getName(), contactName)) {
                return myContacts.get(i);
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");

        for (int i = 0; i < myContacts.size(); i++) {
            Contact target = myContacts.get(i);
            System.out.println(i+1 + ". " + target.getName() + " -> " + target.getPhoneNumber());
        }
    }
}
