package com.bridgelabz;
/**
 * Ability to create a Contacts in Address Book with first and last names, address,city, state, zip, phone
 * Ability to add a new Contact to Address Book, edit, delete person using person's name, ability to add multiple persons
 * to address book, refactor to add multiple address book to the system,to ensure there is no Duplicate entry of the same
 * Person in a particular address book,search Person in a City or State across the multiple AddressBook,view persons by
 * city or state, get number of contacts by city or state, sort the entries in address book alphabetically and
 * Ability to sort the entries in the address book by City, State, or Zip
 * Ability to Read or Write the Address Book with Persons Contact into a File using File IO
 */

import java.io.*;
import java.util.*;

public class AddressBook {
    /**
     * Creating a scanner object to read inputs from user
     */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * Creating a Map object with String type as key and List type as value
     */
    private static Map<String, List<Contact>> addressBook = new HashMap<>();

    /**
     * Creating a map object to store city or state as key and  contacts as list
     */
    private static Map<String, List<Contact>> cityStateContacts = new HashMap<>();


    /**
     * Creating addNewContact method to add contacts into list
     * @param scanner - taking scanner object
     */
    public static void addNewContact(Scanner scanner) {

        System.out.println("Please enter the contact type  1.Office Contact\n2.Personal Contact");
        String contactType = scanner.nextInt() == 1 ? "Office" : "Personal";
        /**
         * Taking all the address book inputs from user and storing them in respective fields as below
         */
        System.out.println("Please enter the details :");
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

        /**
         * Creating Contact object and passing all the details as params
         */
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        /**
         * If there is no existing entry for given contact type then create new array list
         */
        if (addressBook.get(contactType) == null) {
            addressBook.put(contactType, new ArrayList<>());
        }
        if (!addressBook.get(contactType).contains(contact)) {
            addressBook.get(contactType).add(contact);
        }
    }

    /**
     * Creating writeContactsToFile to write the person's contacts to a file
     * @throws IOException
     */
    public static void writeContactsToFile() throws IOException {
        /**
         * Creating a BufferedWriter object
         */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("AddressBook.txt"));
        for (Map.Entry<String, List<Contact>> entry : addressBook.entrySet()) {
            bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
            bufferedWriter.newLine();
        }
        System.out.println("Contact has been saved successfully to a file");
        bufferedWriter.flush();
    }

    /**
     * Creating readContactsFromFile method to read person contacts from a file
     * @throws IOException
     */
    public static void readContactsFromFile() throws IOException {
        /**
         * Creating a BufferedReader object
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("AddressBook.txt"));
        String file;
        while ((file = bufferedReader.readLine()) != null) {
            System.out.println(file);
        }
        bufferedReader.close();
    }

    /**
     * Main method to perform modifications
     * @param args - default java param
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Address Book program...!");
        String userChoice;
        do {
            readUserInput(scanner);
            System.out.println("Do you want to continue(Y/N) ?");
            userChoice = scanner.next();
        } while (userChoice.equalsIgnoreCase("Y"));
        System.out.println("Thank you!");
    }

    /**
     * @param scanner - taking scanner object
     * Method for giving the user to select he option and perform acc to it
     */
    private static void readUserInput(Scanner scanner) throws IOException {
        System.out.println("Please select one option");
        System.out.println("1. Create new contact \n2. Edit contact \n3. List contacts \n" +
                "4. Delete contact \n5. Search Contact \n6. View Contact \n7. CountNumberOfContacts \n" +
                "8. Sort Address Book by Name \n9. Sort Address Book By City State Or Zip \n" +
                "10. Write Contacts To File \n11. Read Contacts From File");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                addNewContact(scanner);
                System.out.println("Contact added successfully!");
                break;
            case 2:
                editContact();
                break;
            case 3:
                listContacts();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                searchContact();
                break;
            case 6:
                viewContact();
                break;
            case 7:
                countNumberOfContacts();
                break;
            case 8:
                sortAddressBookByName();
                break;
            case 9:
                sortAddressBookByCityStateOrZip();
                break;
            case 10:
                writeContactsToFile();
                break;
            case 11:
                readContactsFromFile();
                break;
            default:
                System.out.println("Invalid option. Please select valid");
        }
    }

    /**
     * Method for deleting the contact for the given name as input
     */
    private static void deleteContact() {
        System.out.println("Please enter the contact type  1.Office Contact\n2.Personal Contact");
        String contactType = scanner.nextInt() == 1 ? "Office" : "Personal";
        List<Contact> contactList = addressBook.get(contactType);
        if (contactList == null) {
            System.out.println("No such contact book exists!");
        } else {
            System.out.println("Please enter the name of the person u want to delete :");
            String contactName = scanner.next();
            Iterator<Contact> iterator = contactList.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contactName.equals(contact.getFirstName())) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Displaying the list
     */
    private static void listContacts() {
        for (Map.Entry<String, List<Contact>> entry : addressBook.entrySet()) {
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
    }

    /**
     * This method is used to give the user edit option
     */
    private static void editContact() {
        System.out.println("Please enter the contact type  1.Office Contact\n2.Personal Contact");
        String contactType = scanner.nextInt() == 1 ? "Office" : "Personal";
        List<Contact> contactList = addressBook.get(contactType);
        if (contactList == null) {
            System.out.println("No such contact book exists!");
        } else {
            System.out.println("Please enter the name of the person u want to edit :");
            String contactName = scanner.next();
            Optional<Contact> optionalContact = contactList.stream().filter(contact1 -> contact1.getFirstName().equals(contactName)).findFirst();
            if (!optionalContact.isPresent()) {
                System.out.println("Sorry could not find the contact with the given name");
                return;
            }
            Contact contact = optionalContact.get();
            System.out.println("Please select the field you want to edit ");
            System.out.println("1.Lastname  2.Address  3.City  4.State  5.Zip  6.Phone number  7.email ");
            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Please enter new last name :");
                    String lastName = scanner.next();
                    contact.setLastName(lastName);
                    break;
                case 2:
                    System.out.println("Please enter new address :");
                    String address = scanner.next();
                    contact.setAddress(address);
                    break;
                case 3:
                    System.out.println("Please enter new city :");
                    String city = scanner.next();
                    contact.setCity(city);
                    break;
                case 4:
                    System.out.println("Please enter new state :");
                    String state = scanner.next();
                    contact.setState(state);
                    break;
                case 5:
                    System.out.println("Please enter new zip :");
                    long zip = scanner.nextLong();
                    contact.setZip(zip);
                    break;
                case 6:
                    System.out.println("Please enter new phone number :");
                    long phoneNumber = scanner.nextLong();
                    contact.setPhoneNumber(phoneNumber);
                    break;
                case 7:
                    System.out.println("Please enter new email :");
                    String email = scanner.next();
                    contact.setEmail(email);
                    break;
                default:
                    System.out.println("Invalid option. Please enter valid !");
                    scanner.close();
            }
            listContacts();
        }
    }

    /**
     * Creating a searchContact method to search a contact by city or state name and print the list
     */
    private static void searchContact() {
        System.out.println("Enter city or state name to search: ");
        String inputName = scanner.next();

        addressBook.keySet().stream().forEach(contactType ->
                addressBook.get(contactType).stream().filter(contact -> (contact.getCity().equals(inputName) ||
                        contact.getState().equals(inputName))).forEach(System.out::print));
    }

    /**
     * Creating a viewContact method to provide ability to view Persons by City or State
     */
    private static void viewContact() {
        System.out.println("Please enter the name of city or state you want to view: ");
        String cityOrState = scanner.next();

        addressBook.keySet().stream().forEach(contactType -> {
            addressBook.get(contactType).stream().forEach(contact -> {

                if (cityStateContacts.get(contact.getCity()) == null) {
                    cityStateContacts.put(contact.getCity(), new ArrayList<>());
                }
                cityStateContacts.get(contact.getCity()).add(contact);

                if (cityStateContacts.get(contact.getState()) == null) {
                    cityStateContacts.put(contact.getState(), new ArrayList<>());
                }
                cityStateContacts.get(contact.getState()).add(contact);

            });
        });

        cityStateContacts.get(cityOrState).stream().forEach(System.out::println);
    }

    /**
     * Creating countNumberOfContacts method to count the contact for given state or city
     */
    private static void countNumberOfContacts() {
        if (cityStateContacts == null || cityStateContacts.isEmpty()) {
            viewContact();
        }
        System.out.println("Please enter the name of city or state you want to count: ");
        String cityOrState = scanner.next();
        List<Contact> contactList = cityStateContacts.get(cityOrState);
        System.out.println(contactList != null ? contactList.size() : "Invalid state or city");
    }

    /**
     * Creating sortAddressBookByName to sort the entries in the address book alphabetically by person's first name
     */
    private static void sortAddressBookByName() {
        System.out.println("Please enter the contact type you want to sort  1.Office Contact\n2.Personal Contact");
        String contactType = scanner.nextInt() == 1 ? "Office" : "Personal";

        Collections.sort(addressBook.get(contactType), (a, b) -> a.getFirstName().compareTo(b.getFirstName()));
    }

    /**
     * Creating sortAddressBookByCityStateOrZip to sort the entries in the address book by city,state or zip
     */
    private static void sortAddressBookByCityStateOrZip() {
        System.out.println("Please enter the contact type you want to sort 1.Office Contact\n2.Personal Contact");
        String contactType = scanner.nextInt() == 1 ? "Office" : "Personal";

        Collections.sort(addressBook.get(contactType), Comparator.comparing(Contact::getCity)
                .thenComparing(Contact::getState)
                .thenComparing(Contact::getZip));
    }
}



