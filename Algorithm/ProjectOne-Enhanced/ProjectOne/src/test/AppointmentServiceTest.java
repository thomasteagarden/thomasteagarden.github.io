package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {

    // Helper method to create Date instances
    private Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Test
    @DisplayName("Test to Update appointment date.")
    @Order(1)
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();

        // Add appointment with description "Description" and get its ID
        String appointmentID = service.addAppointment(createDate(2024, Calendar.AUGUST, 1), "Description");

        // Update appointment date using appointment ID
        service.updateAppointmentDate(createDate(2025, Calendar.MAY, 3), appointmentID);

        service.displayAppointmentList();

        Appointment updated = service.getAppointment(appointmentID);
        assertNotNull(updated, "Appointment should exist.");
        assertEquals(createDate(2025, Calendar.MAY, 3), updated.getAppointmentDate(), "Appointment date was not updated.");
    }

    @Test
    @DisplayName("Test to Update appointment description.")
    @Order(2)
    void testUpdateAppointmentDesc() {
        AppointmentService service = new AppointmentService();

        // Add appointment with description "Training" and get its ID
        String appointmentID = service.addAppointment(createDate(2024, Calendar.AUGUST, 1), "Training");

        // Update appointment description using appointment ID
        service.updateAppointmentDescription("Updated Description", appointmentID);

        service.displayAppointmentList();

        // Get appointment by ID and check updated description
        Appointment updated = service.getAppointment(appointmentID);
        assertNotNull(updated, "Appointment should exist after description update.");
        assertEquals("Updated Description", updated.getAppointmentDescription(), "Appointment description was not updated.");
    }

    @Test
    @DisplayName("Test to ensure that service correctly deletes appointments.")
    @Order(3)
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();

        // Add appointment with description "DeleteTest" and get its ID
        String appointmentID = service.addAppointment(createDate(2024, Calendar.AUGUST, 1), "DeleteTest");

        // Delete appointment using the appointment ID
        service.deleteAppointment(appointmentID);

        service.displayAppointmentList();

        // Verify the appointment list is empty
        assertTrue(service.getAppointmentList().isEmpty(), "The appointment was not deleted.");
    }

    @Test
    @DisplayName("Test to ensure that service can add an appointment.")
    @Order(4)
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();

        // Add appointment and get its ID
        String appointmentID = service.addAppointment(createDate(2024, Calendar.AUGUST, 1), "AddTest");

        service.displayAppointmentList();

        Appointment added = service.getAppointment(appointmentID);
        assertNotNull(added, "Appointment was not added correctly.");
    }
}
