/*
 * Name:  Thomas Teagarden
 * Course: CS-320
 * Date: 28 July 2024
 * 4.1 Milestone:  Task.Java
 */

package task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDescription;
	private static AtomicLong idGenerator = new AtomicLong();
	
	public Task(String taskName, String taskDescription) {

		//Geterate taskID
		this.taskID = String.valueOf(idGenerator.getAndIncrement());
	
		//Generate taskID and make sure value is not NULL
		if(taskName == null || taskName.isEmpty()) {
			this.taskName ="NULL";
			//Make sure string is not more than 20, and only capture the first 20 characters
		} else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
		
		//Generate taskDescription and make sure the value is not NULL
		if(taskDescription.isEmpty() || taskDescription == null) {
			this.taskDescription = "NULL";
			//Make sure the taskDescription variable to not more than 50 characters and only captuer the first 50 characters
		} else if (taskDescription.length() > 50) {
			this.taskDescription = taskDescription.substring(0, 50);
		} else {
			this.taskDescription = taskDescription;
		}
	}
	
	//Get taskID
	public String getTaskID() {
		return taskID;
	}
	
	//Get taskName
	public String getTaskName() {
		return taskName;
	}
	
	//Get taskDescription
	public String getTaskDescription() {
		return taskDescription;
	}
	
	//Set taskName
	public void setTaskName(String taskName) {
		if(taskName == null || taskName.isEmpty()) {
			this.taskName ="NULL";
			this.taskName = taskName.substring(0, 20);
		} else {
			this.taskName = taskName;
		}
	}
		
	//Set taskDescription
	public void setTaskDescription(String taskDescription) {
		if(taskDescription.isEmpty() || taskDescription == null) {
			this.taskDescription = "NULL";
		} else if (taskDescription.length() > 50) {
			this.taskDescription = taskDescription.substring(0, 50);
		} else {
			this.taskDescription = taskDescription;
		}
	}
}
