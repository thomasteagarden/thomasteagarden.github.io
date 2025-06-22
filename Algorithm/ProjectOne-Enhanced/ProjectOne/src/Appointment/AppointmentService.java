/* Thomas Teagarden
 * CS 499
 * Description: AppointmentService.java Enhancment
 */

package Appointment;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
    // Create array to hold appointment list
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList; 
    }

    // Display list of appointments
    public void displayAppointmentList() {
        for (Appointment appointment : appointmentList) {
            System.out.println("Appointment ID: " + appointment.getAppointmentID());
            System.out.println("Appointment Date: " + appointment.getAppointmentDate());
            System.out.println("Appointment Description: " + appointment.getAppointmentDescription());
            System.out.println();
        }
    }

    // Add an appointment to the list
    public String addAppointment(Date appointmentDate, String appointmentDescription) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDescription);
        appointmentList.add(appointment);
        return appointment.getAppointmentID();
    }

    // Look up appointment information based on appointment ID
    public Appointment getAppointment(String appointmentID) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return appointment;
            }
        }
        return null; // Not found
    }

    // Delete appointment using the appointment ID
    public void deleteAppointment(String appointmentID) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentID().equals(appointmentID)) {
                appointmentList.remove(i);
                return;
            }
        }
        System.out.println("Appointment ID: " + appointmentID + " not found!");
    }

    // Update appointment date based on appointment ID
    public void updateAppointmentDate(Date updatedDate, String appointmentID) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointment.setAppointmentDate(updatedDate);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment ID: " + appointmentID + " not found!");
        }
    }

    // Update appointment description based on appointment ID
    public void updateAppointmentDescription(String updatedDescription, String appointmentID) {
        boolean found = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointment.setAppointmentDescription(updatedDescription);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment ID: " + appointmentID + " not found!");
        }
    }

    // Get appointment by description
    public Appointment getAppointmentByDescription(String description) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointmentDescription().equals(description)) {
                return appointment;
            }
        }
        return null; // Not found
    }

	// Sort appointment by date
	public void sortAppointmentsByDate() {
        appointmentList.sort((a1, a2) -> a1.getAppointmentDate().compareTo(a2.getAppointmentDate()));
    }

	public ArrayList<Appointment> filterAppointmentsAfterDate(Date date) {
    ArrayList<Appointment> filteredList = new ArrayList<>();
    for (Appointment appointment : appointmentList) {
        if (appointment.getAppointmentDate().after(date)) {
            filteredList.add(appointment);
        }
    }
    return filteredList;
	}

	public ArrayList<Appointment> filterAppointmentsBeforeDate(Date date) {
    ArrayList<Appointment> filteredList = new ArrayList<>();
    for (Appointment appointment : appointmentList) {
        if (appointment.getAppointmentDate().before(date)) {
            filteredList.add(appointment);
        }
    }
    return filteredList;
	}

	public ArrayList<Appointment> filterAppointmentsByKeyword(String keyword) {
    ArrayList<Appointment> filteredList = new ArrayList<>();
    for (Appointment appointment : appointmentList) {
        if (appointment.getAppointmentDescription().toLowerCase().contains(keyword.toLowerCase())) {
            filteredList.add(appointment);
        }
    }
    return filteredList;
	}


}
