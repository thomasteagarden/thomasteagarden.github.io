/*
 * Name:  Thomas Teagarden
 * Course: CS-320
 * Date: 28 July 2024
 * 4.1 Milestone: TaskTest.Java
*/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {
	//Test Task Class
	
	@Test
	@DisplayName("Task ID cannot be more than 10 characters")
	void testTaskIDExcessCharacters() {
		Task task = new Task("Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}
	@Test
	@DisplayName("Task Name cannot have more than 20 characters")
	void testTaskNameWithExcessChatacters() {
		Task task = new Task("FollowTheLeader", "Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}

	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescExcessCharacters() {
		Task task = new Task("Name", "Follow the leader because that is what we do!" 
				+ " Follow the leader because that is what we do!" 
				+ " Follow the leader because that is what we do!"
				+ " Follow the leader because that is what we do!");
		if (task.getTaskDescription().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}

	@Test
	@DisplayName("Task Name shall not be null")
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getTaskName(), "Task Name was null.");
	}
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testTaskDescNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getTaskDescription(), "Task Description was null.");
	}
}

