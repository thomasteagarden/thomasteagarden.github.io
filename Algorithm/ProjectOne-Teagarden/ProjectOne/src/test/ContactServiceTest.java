/**
 * * Name:  Thomas Teagarden
 * Course:  CS-320
 * Module 3-2:  Contact Service Test Class
 */

package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Contact.Contact;
import Contact.ContactService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)

public class ContactServiceTest{
	//This test will test the aspects of the ContactService Class
	
	@Test
	@DisplayName("Test to Update First Name.")
	@Order(1)
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.updateFirstName("Deliah", "9");
		service.dispayContactList();
		assertEquals("Deliah", service.getContact("9").getFirstName(), "First name was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update Last Name.")
	@Order(2)
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.updateLastName("Dinosaure", "11");
		service.dispayContactList();
		assertEquals("Dinosaure", service.getContact("11").getLastName(), "Last name was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update Phone Number.")
	@Order(3)
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.updateNumber("1029384756", "17");
		//service.displayContactList();
		assertEquals("1029384756", service.getContact("17").getNumber(), "Phone number was not updated.");
	}

	@Test
	@DisplayName("Test to Update Address.")
	@Order(4)
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.updateAddress("234 South Street", "15");
		service.dispayContactList();
		assertEquals("234 South Street", service.getContact("15").getAddress(), "Address was not updated.");
	}

	@Test
	@DisplayName("Test to Deletes Contacts.")
	@Order(5)
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.deleteContact("17");
		// Ensure that the contactList is now empty by creating a new empty contactList to compare it with
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		service.dispayContactList();
		assertEquals(service.contactList, contactListEmpty, "The contact was not deleted.");
	}

	@Test
	@DisplayName("Test to Add Contact.")
	@Order(6)
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("Captain", "Peter", "7657687987", "123 Main Street");
		service.dispayContactList();
		assertNotNull(service.getContact("0"), "Contact was not added correctly.");
	}

}
