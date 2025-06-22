/**
 * Name:  Thomas Teagarden
 * Course:  CS-320
 * Module 3-2:  Contact Service Class
 */

package Contact;

import java.util.ArrayList;

public class ContactService {
	//Create ArrayList for contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	//Display Contacts
	public void dispayContactList() {
		for (int counter = 0; counter < contactList.size(); counter++) {
			System.out.println("Contact ID: " + contactList.get(counter).getContactID());
			System.out.println("First Name: " + contactList.get(counter).getFirstName());
			System.out.println("Last Name: " + contactList.get(counter).getLastName());
			System.out.println("Phome Number: " + contactList.get(counter).getNumber());
			System.out.println("Address: " + contactList.get(counter).getAddress() + "\n");
		}
	}
	//Add new contact
	public void addContact(String firstName, String lastName, String number, String address) {
		//Create new contact and add it to array
		Contact contact = new Contact(firstName, lastName, number, address);
		contactList.add(contact);
	}
	
	//Look up contact
	public Contact getContact(String contactID) {
		Contact contact = new Contact (null, null, null, null);
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contact = contactList.get(counter);
			}
		}
		
	return contact;
	}
	
	//Delete contact
	public void deleteContact(String contactID) {
		for (int counter = 0; counter < contactList.size(); counter ++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.remove(counter);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}
	
	//Update contact First Name
	public void updateFirstName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setFirstName(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
	}
	
	//Update contact Last Name
	public void updateLastName(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setLastName(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
			
		}
	}
	
	//Update contact Phone Number
	public void updateNumber(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setNumber(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
				
	}
	
	//Update contact Address
	public void updateAddress(String updatedString, String contactID) {
		for (int counter = 0; counter < contactList.size(); counter++) {
			if (contactList.get(counter).getContactID().equals(contactID)) {
				contactList.get(counter).setAddress(updatedString);
				break;
			}
			if (counter == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not found.");
			}
		}
		
	}
}
