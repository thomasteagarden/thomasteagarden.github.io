/*
 * Thomas Teagarden
 * CS 499
 * Description: Appointment.java Enhancement
 */

package Appointment;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Calendar;
import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDescription;
    private static final AtomicLong idGenerator = new AtomicLong();

    // Constructors
    public Appointment(Date appointmentDate, String appointmentDescription) {
        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());

        setAppointmentDate(appointmentDate);           // Uses internal setter
        setAppointmentDescription(appointmentDescription); // Uses internal setter
    }

    // Getters
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    // Setters
    public void setAppointmentDate(Date date) {
        Date now = new Date();

        if (date == null) {
            // Use Calendar to set default date: August 1, 2024
            Calendar cal = Calendar.getInstance();
            cal.set(2024, Calendar.AUGUST, 1, 0, 0, 0);
            cal.set(Calendar.MILLISECOND, 0);
            this.appointmentDate = cal.getTime();
        } else if (date.before(now)) {
            throw new IllegalArgumentException("Cannot make appointment before current date!");
        } else {
            this.appointmentDate = date;
        }
    }

    public void setAppointmentDescription(String description) {
        if (description == null || description.isEmpty()) {
            this.appointmentDescription = "NULL";
        } else if (description.length() > 50) {
            this.appointmentDescription = description.substring(0, 50);
        } else {
            this.appointmentDescription = description;
        }
    }
}
