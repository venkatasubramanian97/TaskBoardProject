package com.example.TaskBoard.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskBoard")

public class TaskBoard {
	@Id
	private String id;
	private String taskId;
	private LocalDate date;
	private TaskType taskType;
	private String projectName;
	private String projectOwnerId;
	private String employeeId;
	private String resourceName;
	private String title;
	private String titleDescription;
	private TaskStatus taskStatus;
	private LocalDateTime estimationTime;
	private LocalDateTime actualTime;
	private String comments;

	// Enum for Task Status
	public enum TaskStatus {
		INPROGRESS, BACKLOG, BLOCKED, DONE, PENDING, REOPEN
	}

	// Enum for Task Type
	public enum TaskType {
		FEATURE, BUGFIXES, TESTING, TECDISC, BUSDISC, OTHERS
	}

	// Default constructor
	public TaskBoard() {
	}

	// Parameter constructor
	public TaskBoard(String taskId, LocalDate date, TaskType taskType, String projectName, String projectOwnerId,
			String employeeId, String resourceName, String title, String titleDescription, TaskStatus taskStatus,
			LocalDateTime estimationTime, LocalDateTime actualTime, String comments) {
		super();
		this.taskId = taskId;
		this.date = date;
		this.taskType = taskType;
		this.projectName = projectName;
		this.projectOwnerId = projectOwnerId;
		this.employeeId = employeeId;
		this.resourceName = resourceName;
		this.title = title;
		this.titleDescription = titleDescription;
		this.taskStatus = taskStatus;
		this.estimationTime = estimationTime;
		this.actualTime = actualTime;
		this.comments = comments;
	}

	// Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectOwnerId() {
		return projectOwnerId;
	}

	public void setProjectOwnerId(String projectOwnerId) {
		this.projectOwnerId = projectOwnerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleDescription() {
		return titleDescription;
	}

	public void setTitleDescription(String titleDescription) {
		this.titleDescription = titleDescription;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDateTime getEstimationTime() {
		return estimationTime;
	}

	public void setEstimationTime(LocalDateTime estimationTime) {
		this.estimationTime = estimationTime;
	}

	public LocalDateTime getActualTime() {
		return actualTime;
	}

	public void setActualTime(LocalDateTime actualTime) {
		this.actualTime = actualTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
