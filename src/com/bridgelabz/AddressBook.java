/**
 * Ability to add a new Contact to Address Book
 */
package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private static List<Contact> contactList = new ArrayList<>();

    public static void addNewContact(Scanner scanner) {
        System.out.println("Please Enter the Contact Details");
        System.out.println("First Name :");
        String firstName = scanner.next();
        System.out.println("Last Name :");
        String lastName = scanner.next();
        System.out.println("Address :");
        String address = scanner.next();
        System.out.println("City :");
        String city = scanner.next();
        System.out.println("State :");
        String state = scanner.next();
        System.out.println("Zip :");
        long zip = scanner.nextLong();
        System.out.println("Phone Number :");
        long phoneNumber = scanner.nextLong();
        System.out.println("Email :");
        String email = scanner.next();
        contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program...!");
        Scanner scanner = new Scanner(System.in);
        AddressBook.readUserInput(scanner);
    }

    private static void readUserInput(Scanner scanner) {
        System.out.println("Create new contact");
        addNewContact(scanner);
        System.out.println("Contact added successfully!");
    }
}
