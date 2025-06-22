package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {
    // Test Task Class

    @Test
    @DisplayName("Task ID cannot be more than 10 characters")
    void testTaskIDExcessCharacters() {
        Task task = new Task("Name", "Description");
        assertTrue(task.getTaskID().length() <= 10, "Task ID has more than 10 characters.");
    }

    @Test
    @DisplayName("Task Name cannot have more than 20 characters")
    void testTaskNameWithExcessCharacters() {
        Task task = new Task("FollowTheLeader", "Description");
        assertTrue(task.getTaskName().length() <= 20, "Task Name has more than 20 characters.");
    }

    @Test
    @DisplayName("Task Description cannot have more than 50 characters")
    void testTaskDescExcessCharacters() {
        Task task = new Task("Name", "Follow the leader because that is what we do!" 
                + " Follow the leader because that is what we do!" 
                + " Follow the leader because that is what we do!"
                + " Follow the leader because that is what we do!");
        assertTrue(task.getTaskDescription().length() <= 50, "Task Description has more than 50 characters.");
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
