package com.bridgelabz;

/**
 * Creating a Contact class which contain all the details like first name,last name,phone number and so on
 * Containing all the getter and setter methods for the variables
 */

public class Contact {
    /**
     * Declaring the variables for the details of a contact
     */
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private long zip;
    private long phoneNumber;
    private String email;

    /**
     * Creating a parameterised constructor to take all the below params
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param phoneNumber
     * @param email
     */
    Contact(String firstName, String lastName, String address, String city,
            String state, long zip, long phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * creating getter and setter methods for each variable
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Overriding equals method for comparing the first name
     * @param o - of type Object
     * @return true or false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return this.firstName.equalsIgnoreCase(contact.getFirstName());
    }

    /**
     * Overriding toString method to print the list in a format
     * @return - list of contacts with details
     */
    @Override
    public String toString() {
        return  "\tFirstName: " + firstName + '\n' +
                "\tLastName: " + lastName + '\n' +
                "\tAddress: " + address + '\n' +
                "\tCity: " + city + '\n' +
                "\tState: " + state + '\n' +
                "\tZip: " + zip + '\n' +
                "\tPhoneNumber: " + phoneNumber + '\n' +
                "\tEmail: " + email + '\n' ;
    }
}
