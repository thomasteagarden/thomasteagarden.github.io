/**
 * * Name:  Thomas Teagarden
 * Course:  CS-499
 * Module 3-2:  Contact Test Class Enhancement
 */
package test;

import org.junit.jupiter.api.Test;

import Contact.Contact;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	//This will test the Contact Class
	
	@Test
	@DisplayName("Contact ID cannot have more than 10 characters")
	void testContactIDLimit() {
		Contact contact = new Contact("FirstName", "LastName", "Phone", "Address");
		if (contact.getContactID().length() > 10) {
			fail("Contact ID has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testContactFirstNameLimit() {
		Contact contact = new Contact("Tarzan", "LastName", "Phone", "Address");
		if (contact.getFirstName().length() > 10) {
			fail("First Name has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testContactLastNameLimit() {
		Contact contact = new Contact("FirstName", "McFred", "Phone", "Address");
		if (contact.getLastName().length() > 10) {
			fail("Last Name has more than 10 characters.");
		}
	}

	@Test
	@DisplayName("Contact phone number is exactly 10 characters")
	void testContactNumberLimit() {
		Contact contact = new Contact("FirstName", "LastName", "1029384756", "Address");
		if (contact.getNumber().length() != 10) {
			fail("Phone number length does not equal 10.");
		}
	}

	@Test
	@DisplayName("Contact address cannot have more than 30 characters")
	void testContactAddressLimit() {
		Contact contact = new Contact("FirstName", "LastName", "Phone", "134 Nightingale Ln");
		if (contact.getAddress().length() > 30) {
			fail("Address has more than 30 characters.");
		}
	}

	@Test
	@DisplayName("Contact First Name shall not be null")
	void testContactFirstNameNotNull() {
		Contact contact = new Contact(null, "LastName", "Phone", "Address");
		assertNotNull(contact.getFirstName(), "First name was null.");
	}

	@Test
	@DisplayName("Contact Last Name shall not be null")
	void testContactLastNameNotNull() {
		Contact contact = new Contact("FirstName", null, "Phone", "Address");
		assertNotNull(contact.getLastName(), "Last name was null.");
	}

	@Test
	@DisplayName("Contact Phone Number shall not be null")
	void testContactPhoneNotNull() {
		Contact contact = new Contact("FirstName", "LastName", null, "Address");
		assertNotNull(contact.getNumber(), "Phone number was null.");
	}

	@Test
	@DisplayName("Contact Address shall not be null")
	void testContactAddressNotNull() {
		Contact contact = new Contact("FirstName", "LastName", "Phone", null);
		assertNotNull(contact.getAddress(), "Address was null.");
	}
}