/**
 * Name: Thomas Teagarden
 * Course: CS-499
 * Module 3-2: Contact Service Class Enhancement
 */

package Contact;

import java.util.ArrayList;

public class ContactService {
    // List to store contacts
    public ArrayList<Contact> contactList = new ArrayList<>();

    /**
     * Display all contacts in the list.
     */
    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println("Contact ID: " + contact.getContactID());
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Phone Number: " + contact.getNumber());
            System.out.println("Address: " + contact.getAddress() + "\n");
        }
    }

    /**
     * Adds a new contact to the list.
     */
    public void addContact(String firstName, String lastName, String number, String address) {
        Contact contact = new Contact(firstName, lastName, number, address);
        contactList.add(contact);
    }

    /**
     * Retrieves a contact by its ID.
     */
    public Contact getContact(String contactID) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null; // Return null if contact not found
    }

    /**
     * Deletes a contact by its ID.
     */
    public void deleteContact(String contactID) {
        boolean found = false;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactID().equals(contactID)) {
                contactList.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    /**
     * Updates the first name of a contact by ID.
     */
    public void updateFirstName(String updatedString, String contactID) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setFirstName(updatedString);
        } else {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    /**
     * Updates the last name of a contact by ID.
     */
    public void updateLastName(String updatedString, String contactID) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setLastName(updatedString);
        } else {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    /**
     * Updates the phone number of a contact by ID.
     */
    public void updateNumber(String updatedString, String contactID) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setNumber(updatedString);
        } else {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

    /**
     * Updates the address of a contact by ID.
     */
    public void updateAddress(String updatedString, String contactID) {
        Contact contact = getContact(contactID);
        if (contact != null) {
            contact.setAddress(updatedString);
        } else {
            System.out.println("Contact ID: " + contactID + " not found.");
        }
    }

	/**
     * Sorts the contact list by last name, then by first name.
     */
    public void sortContactsByName() {
        contactList.sort((c1, c2) -> {
            int lastNameCompare = c1.getLastName().compareToIgnoreCase(c2.getLastName());
            if (lastNameCompare != 0) {
                return lastNameCompare;
            }
            return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
        });
    }

	// Filter contacts by first name (case-insensitive exact match)
	public ArrayList<Contact> filterByFirstName(String firstName) {
    	ArrayList<Contact> filtered = new ArrayList<>();
    	for (Contact contact : contactList) {
        	if (contact.getFirstName().equalsIgnoreCase(firstName)) {
            	filtered.add(contact);
        	}
    	}
    	return filtered;
	}

	// Filter contacts by last name (case-insensitive exact match)
	public ArrayList<Contact> filterByLastName(String lastName) {
    	ArrayList<Contact> filtered = new ArrayList<>();
    	for (Contact contact : contactList) {
        	if (contact.getLastName().equalsIgnoreCase(lastName)) {
            	filtered.add(contact);
        	}
    	}
    	return filtered;
	}

	// Filter contacts by phone number (exact match)
	public ArrayList<Contact> filterByNumber(String number) {
    	ArrayList<Contact> filtered = new ArrayList<>();
    	for (Contact contact : contactList) {
        	if (contact.getNumber().equals(number)) {
            	filtered.add(contact);
        	}
    	}
    	return filtered;
	}

	// Filter contacts by address keyword (case-insensitive partial match)
	public ArrayList<Contact> filterByAddressKeyword(String keyword) {
    	ArrayList<Contact> filtered = new ArrayList<>();
    	String lowerKeyword = keyword.toLowerCase();
    	for (Contact contact : contactList) {
        	if (contact.getAddress().toLowerCase().contains(lowerKeyword)) {
            	filtered.add(contact);
        	}
    	}
    	return filtered;
	}
}
