/*Thomas Teagarden
 * CS 320
 * Description:  AppointmentService.java
 */

package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	//Create array to hold appointment list
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	//Display list of appointments
	public void displayAppointmentList() {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			System.out.println("Appointment ID: " + appointmentList.get(counter).getAppointmentID());
			System.out.println("Appointment Date: " + appointmentList.get(counter).getAppointmentDate());
			System.out.println("Appointment Description: " + appointmentList.get(counter).getAppointmentDescription());
		}
	}
	// Add an appointment to the list
	public void addAppointment(Date appointmentDate, String appointmentDescription) {
		//Create new appointment
		Appointment appointment = new Appointment(appointmentDate, appointmentDescription);
		appointmentList.add(appointment);
	}
	
	//Look up appointment information based on appointment ID
	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment (null, null);
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().contentEquals(appointmentID)) {
				appointment = appointmentList.get(counter);
			}
		}
		
		return appointment;
	}
	
	//Delete appointment using the appointment ID
	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.remove(counter);
				break;
			}
			if (counter == appointmentList.size() -1) {
				System.out.println("Appointment ID: " + appointmentID + " not found!");
			}
		}
	}
	
	//Update appointment date based on appointment ID
	public void updateAppointmentDate (Date updatedDate, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDate(updatedDate);;
				break;
			}
			if (counter == appointmentList.size() -1) {
				System.out.println("Appointment ID: " + appointmentID + " not found!");
			}
		}
	}
	
	//Update appointment description based on appointment ID
	public void updateAppointmentDescription(String updatedString, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
				appointmentList.get(counter).setAppointmentDescription(updatedString);
				break;
			}
		}
	}
}
