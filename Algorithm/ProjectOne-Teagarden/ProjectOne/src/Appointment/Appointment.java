/*
 * Thomas Teagarden
 * CS 320
 * Description:  Appointment.java
 */

package Appointment;

import java.util.concurrent.atomic.*;
import java.util.Calendar;
import java.util.Date;
;
public class Appointment {
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	private static AtomicLong idGenerator = new AtomicLong();
	
	//Constructors
	@SuppressWarnings("deprecation")
	public Appointment(Date appointmentDate, String appointmentDescription) {
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		//If date is null
		if (appointmentDate == null) {
			this.appointmentDate = new Date(2024, Calendar.AUGUST, 1);
			//if appointment date is in the past
		} else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException ( "Cannot make appointment before current date!");
		} else {
			this.appointmentDate = appointmentDate;
		}
		//if appointment description is empty or null
		if (appointmentDescription == null || appointmentDescription.isEmpty()) {
			this.appointmentDescription = "NULL";
			//only capture the first 50 characters
		} else if (appointmentDescription.length() > 50) {
			this.appointmentDescription = appointmentDescription.substring(0, 50);
		} else {
			this.appointmentDescription = appointmentDescription;
		}
	}
	//Get appointment ID
	public String getAppointmentID() {
		return appointmentID;
	}
	//get appointment date
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	//get appointment descritpion
	public String getAppointmentDescription() {
		return appointmentDescription;
	}

	@SuppressWarnings("deprecation")
	//Set appointment date
	public void setAppointmentDate(Date appointmentDate) {
		//If date is null
		if (appointmentDate == null) {
			this.appointmentDate = new Date(2024, Calendar.AUGUST, 1);
		//if appointment date is in the past
		} else if (appointmentDate.before(new Date())) {
			throw new IllegalArgumentException ( "Cannot make appointment before current date!");
		} else {
			this.appointmentDate = appointmentDate;
		}
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		//if appointment description is empty or null
		if (appointmentDescription == null || appointmentDescription.isEmpty()) {
			this.appointmentDescription = "NULL";
		//only capture the first 50 characters
		} else if (appointmentDescription.length() > 50) {
			this.appointmentDescription = appointmentDescription.substring(0, 50);
		} else {
			this.appointmentDescription = appointmentDescription;
		}
	}
}