/**
 * * Name:  Thomas Teagarden
 * Course:  CS-320
 * Module 3-2:  Contact Class
 */

package Contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	private static AtomicLong idGenerator = new AtomicLong();
	
	public Contact(String firstName, String lastName, String number, String Address) {
		//Generate contact ID.  This is static so it cannot be changed and is not duplicated.
		this.contactID = String.valueOf(idGenerator.getAndIncrement());
		
		//First name.  Make sure first name is not empty or null.
		if(firstName.isEmpty()|| firstName == null) {
			this.firstName = "NULL";
			//Checks to see if the first name is not longer than 10, and if it is only accept the first 10 characters.
		} else if (firstName.length() > 10 ) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}
		
		//Last name.  Make sure that last name is not empty and is not null.
		if(lastName.isEmpty() || lastName == null) {
			this.lastName = "NULL";
		//Check to see if the last name is larger than 10 and only accepts the first 10 characters. 			
		}else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
		
		//Number.  Make sure number is exactly 10 digits and that the value is not null or empty.
		if(number.length() != 10 || number == null || number.isEmpty()) {
			this.number = "1234567890";
		} else {
			this.number = number;
		}
		
		//Address.  Makes sure the address is not null or empty.
		if(address.isEmpty() || address == null) {
			this.address = "NULL";
		}
		//Makes sure the address is not more than 30 characters.
		else if(address.length() > 30) {
			this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}
	
	//Get ContactID
	public String getContactID() {
		return contactID;
	}
	
	//Get First Name
	public String getFirstName() {
		return firstName;
	}
	
	//Get Last Name
	public String getLastName() {
		return lastName;
	}
	
	//Get Number
	public String getNumber() {
		return number;
	}
	
	//Get Address
	public String getAddress() {
		return address;
	}
	
	//Set First Name
	public void setFirstName(String firstName) {
		//First name.  Make sure first name is not empty or null.
		if(firstName.isEmpty()|| firstName == null) {
			this.firstName = "NULL";
		//Checks to see if the first name is not longer than 10, and if it is only accept the first 10 characters.
		} else if (firstName.length() > 10 ) {
			this.firstName = firstName.substring(0, 10);
		} else {
			this.firstName = firstName;
		}
	}
	
	//Set Last Name
	public void setLastName(String lastName) {
		if(lastName.isEmpty() || lastName == null) {
			this.lastName = "NULL";
		//Check to see if the last name is larger than 10 and only accepts the first 10 characters. 			
		}else if (lastName.length() > 10) {
			this.lastName = lastName.substring(0, 10);
		} else {
			this.lastName = lastName;
		}
	}
	
	//Set Number
	public void setNumber(String number) {
		//Number.  Make sure number is exactly 10 digits and that the value is not null or empty.
		if(number.length() != 10 || number == null || number.isEmpty()) {
			this.number = "1234567890";
		} else {
			this.number = number;
		}
	}
	
	//Set Address
	public void setAddress(String address) {
		//Address.  Makes sure the address is not null or empty.
		if(address.isEmpty() || address == null) {
			this.address = "NULL";
		}
		//Makes sure the address is not more than 30 characters.
		else if(address.length() > 30) {
				this.address = address.substring(0, 30);
		} else {
			this.address = address;
		}
	}
}
