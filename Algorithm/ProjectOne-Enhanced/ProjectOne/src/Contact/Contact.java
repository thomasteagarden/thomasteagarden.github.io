/**
 * Name: Thomas Teagarden
 * Course: CS-499
 * Module 3-2: Contact Class Enhancement
 */

package Contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String number;
    private String address;
    private static final AtomicLong idGenerator = new AtomicLong();

    public Contact(String firstName, String lastName, String number, String address) {
        // Generate contact ID
        this.contactID = String.valueOf(idGenerator.getAndIncrement());

        setFirstName(firstName);
        setLastName(lastName);
        setNumber(number);
        setAddress(address);
    }

    // Getters

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            this.firstName = "NULL";
        } else if (firstName.length() > 10) {
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            this.lastName = "NULL";
        } else if (lastName.length() > 10) {
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }
    }

    public void setNumber(String number) {
        if (number == null || number.isEmpty() || number.length() != 10) {
            this.number = "1234567890";
        } else {
            this.number = number;
        }
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            this.address = "NULL";
        } else if (address.length() > 30) {
            this.address = address.substring(0, 30);
        } else {
            this.address = address;
        }
    }
}
