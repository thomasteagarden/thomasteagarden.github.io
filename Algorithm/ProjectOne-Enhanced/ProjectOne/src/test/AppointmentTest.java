/* Thomas Teagarden
 * CS 499
 * Description:  Test of Appointment.java Enhancement
 */


package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

    private Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Test
    @DisplayName("Appointment ID cannot have more than 10 characters")
    void testAppointmentIDWithExecessCharacters() {
        Appointment appointment = new Appointment(createDate(2024, Calendar.AUGUST, 1), "Description");
        if (appointment.getAppointmentID().length() > 10) {
            fail("Appointment ID has more than 10 characters.");
        }
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testAppointmentDescWithMoreThanFiftyCharacters() {
        Appointment appointment = new Appointment(createDate(2024, Calendar.AUGUST, 1),
                "Say it ain't so" +
                " we will not go " +
                "Turn the lights off " +
                "carry me home!");
        if (appointment.getAppointmentDescription().length() > 50) {
            fail("Appointment Description has more than 50 characters.");
        }
    }

    @Test
    @DisplayName("Appointment Date cannot be before current date")
    void testAppointmentDateBeforeCurrent() {
        Appointment appointment = new Appointment(createDate(1, Calendar.JANUARY, 1), "Description");
        if (appointment.getAppointmentDate().before(new Date())) {
            fail("Appointment Date is before current date.");
        }
    }

    @Test
    @DisplayName("Task Date shall not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date was null.");
    }

    @Test
    @DisplayName("Task Description shall not be null")
    void testAppointmentDescNotNull() {
        Appointment task = new Appointment(createDate(2024, Calendar.AUGUST, 1), null);
        assertNotNull(task.getAppointmentDescription(), "Appointment Description was null.");
    }
}
