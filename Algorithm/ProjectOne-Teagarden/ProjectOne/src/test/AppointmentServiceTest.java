/*Thomas Teagarden
 * CS 320
 * Descripton:  Appointment Service Test.java
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;
import Appointment.AppointmentService;

class AppointmentServiceTest {
	private Date Date(int i, int january, int j) {
		return null;
	}
	
	@Test
	@DisplayName("Test to Update appointment date.")
	@Order(1)
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.AUGUST, 1), "Description");
		service.updateAppointmentDate(Date(2025, Calendar.MAY, 3), "Pizza Party");
		service.displayAppointmentList();
		assertEquals(Date(2025, Calendar.MAY, 3), service.getAppointment("Pizza Party").getAppointmentDate(), "Appointment date was not updated.");
	}
	
	@Test
	@DisplayName("Test to Update appointment description.")
	@Order(2)
	void testUpdateAppointmentDesc() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.AUGUST, 1), "Description");
		service.updateAppointmentDescription("Updated Description", "Training");
		service.displayAppointmentList();
		assertEquals("Updated Description", service.getAppointment("Training").getAppointmentDescription(), "Appointment description was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes appointments.")
	@Order(3)
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.AUGUST, 1), "Description");
		service.deleteAppointment("11");
		// Ensure that the AppointmentList is now empty by creating a new empty AppointmentList to compare it with
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();
		service.displayAppointmentList();
		assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add an appointment.")
	@Order(4)
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addAppointment(Date(2024, Calendar.AUGUST, 1), "Description");
		service.displayAppointmentList();
		assertNotNull(service.getAppointment("1"), "Appointment was not added correctly.");
	}
}

