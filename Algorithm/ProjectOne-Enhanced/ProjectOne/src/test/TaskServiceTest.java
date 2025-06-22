package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import task.TaskService;

public class TaskServiceTest {
    // Test aspects of the TaskService Class
    
    @Test
    @DisplayName("Test to Update task name")
    @Order(1)
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");

        // Use the ID of the first added task, assumed to be "0"
        service.updateTaskName("Updated Task Name", "0");

        assertEquals("Updated Task Name", service.getTask("0").getTaskName(), "Task name was not updated.");
    }

    @Test
    @DisplayName("Test to Update task description.")
    @Order(2)
    void testUpdateTaskDesc() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");

        service.updateTaskDescription("Updated Description", "0");

        assertEquals("Updated Description", service.getTask("0").getTaskDescription(), "Task description was not updated.");
    }

    @Test
    @DisplayName("Test to ensure that service correctly deletes tasks.")
    @Order(5)
    void testDeleteTask() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");

        service.deleteTask("0");

        // Use the public getter instead of accessing the private taskList
        assertTrue(service.getTaskList().isEmpty(), "The task was not deleted.");
    }

    @Test
    @DisplayName("Test to ensure that service can add a task.")
    @Order(6)
    void testAddTask() {
        TaskService service = new TaskService();
        service.addTask("Task Name", "Description");

        assertNotNull(service.getTask("0"), "Task was not added correctly.");
    }
}
