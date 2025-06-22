/*
 * Name:  Thomas Teagarden
 * Course: CS-320
 * Date: 28 July 2024
 * 4.1 Milestone: TaskService.Java
*/

package task;

import java.util.ArrayList;

public class TaskService {
	//Create ArrayList to hold task listing
	public ArrayList<Task> taskList = new ArrayList<Task>();
	
	//Display list of contacts
	public void displayTaskList() {
		for (int counter = 0; counter < taskList.size(); counter++) {
			System.out.println("Task ID: " + taskList.get(counter).getTaskID());
			System.out.println("Task Name: " + taskList.get(counter).getTaskName());
			System.out.println("Task Description: " + taskList.get(counter).getTaskDescription());
		}
	}
	
	//Add new task
	public void addTask(String taskName, String taskDescription) {
		//Create a new task
		Task task = new Task(taskName, taskDescription);
			taskList.add(task);
	}
	
	//Return task output with taskID
	public Task getTask(String taskID) {
		Task task = new Task(null, null);
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID)) {
				task = taskList.get(counter);
			}
		}
		return task;
	}
	
	//Delete task
	public void deleteTask(String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID)) {
				taskList.remove(counter);
				break;
			}
			if (counter == taskList.size() -1 ) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}
	
	//Update task name
	public void updateTaskName(String updatedString, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID)) {
				taskList.get(counter).setTaskName(updatedString);
				break;
			}
			
			if (counter == taskList.size() -1) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}
	
	//Update task description
	public void updateTaskDescription(String updatedString, String taskID) {
		for (int counter = 0; counter < taskList.size(); counter++) {
			if (taskList.get(counter).getTaskID().contentEquals(taskID)) {
				taskList.get(counter).setTaskDescription(updatedString);
				break;
			}
			if (counter == taskList.size() -1) {
				System.out.println("Task ID: " + taskID + " not found.");
			}
		}
	}
}
