/*
 * Name:  Thomas Teagarden
 * Course: CS-499
 * 4.1 Milestone:  TaskService.Java Enhancement
 */

package task;

import java.util.ArrayList;

public class TaskService {
    // List to hold tasks
    private final ArrayList<Task> taskList = new ArrayList<>();

    // Return a defensive copy of the task list
    public ArrayList<Task> getTaskList() {
        return new ArrayList<>(taskList); // defensive copy to preserve encapsulation
    }

    // Display list of tasks
    public void displayTaskList() {
        for (Task task : taskList) {
            System.out.println("Task ID: " + task.getTaskID());
            System.out.println("Task Name: " + task.getTaskName());
            System.out.println("Task Description: " + task.getTaskDescription());
        }
    }

    // Add new task
    public void addTask(String taskName, String taskDescription) {
        Task task = new Task(taskName, taskDescription);
        taskList.add(task);
    }

    // Return task by taskID
    public Task getTask(String taskID) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                return task;
            }
        }
        return null; // Return null if not found
    }

    // Delete task by taskID
    public void deleteTask(String taskID) {
        boolean found = false;
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskID().equals(taskID)) {
                taskList.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

    // Update task name by taskID
    public void updateTaskName(String updatedString, String taskID) {
        Task task = getTask(taskID);
        if (task != null) {
            task.setTaskName(updatedString);
        } else {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

    // Update task description by taskID
    public void updateTaskDescription(String updatedString, String taskID) {
        Task task = getTask(taskID);
        if (task != null) {
            task.setTaskDescription(updatedString);
        } else {
            System.out.println("Task ID: " + taskID + " not found.");
        }
    }

	    /**
     * Sort tasks alphabetically by task name.
     */
    public void sortTasksByName() {
        taskList.sort((t1, t2) -> t1.getTaskName().compareToIgnoreCase(t2.getTaskName()));
    }

	// Filter tasks by exact task name (case-insensitive)
	public ArrayList<Task> filterByTaskName(String taskName) {
    	ArrayList<Task> filtered = new ArrayList<>();
    	for (Task task : taskList) {
        	if (task.getTaskName().equalsIgnoreCase(taskName)) {
            	filtered.add(task);
        	}
    	}
    	return filtered;
	}

	// Filter tasks by partial task name (case-insensitive)
	public ArrayList<Task> filterByTaskNameContains(String keyword) {
    	ArrayList<Task> filtered = new ArrayList<>();
    	String lowerKeyword = keyword.toLowerCase();
    	for (Task task : taskList) {
        	if (task.getTaskName().toLowerCase().contains(lowerKeyword)) {
            	filtered.add(task);
        	}
    	}
    	return filtered;
	}

	// Filter tasks by partial task description (case-insensitive)
	public ArrayList<Task> filterByTaskDescriptionContains(String keyword) {
    	ArrayList<Task> filtered = new ArrayList<>();
    	String lowerKeyword = keyword.toLowerCase();
    	for (Task task : taskList) {
        	if (task.getTaskDescription().toLowerCase().contains(lowerKeyword)) {
            	filtered.add(task);
        	}
    	}
    	return filtered;
	}
}
