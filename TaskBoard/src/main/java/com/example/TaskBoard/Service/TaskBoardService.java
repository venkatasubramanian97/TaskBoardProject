package com.example.TaskBoard.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskBoard.Model.TaskBoard;
import com.example.TaskBoard.Repository.TaskBoardRepository;

@Service
public class TaskBoardService {
	@Autowired
	private TaskBoardRepository taskBoardRepository;

	// Get all tasks
	public List<TaskBoard> getAllTasks() {
		return taskBoardRepository.findAll();
	}

	// Get a task by ID
	public Optional<TaskBoard> getTaskById(String id) {
		return taskBoardRepository.findById(id);
	}

	// Create a new task
	public TaskBoard createTask(TaskBoard taskBoard) {
		return taskBoardRepository.save(taskBoard);
	}

	// Update an existing task
	public TaskBoard updateTask(String id, TaskBoard taskBoardDetails) {
		Optional<TaskBoard> taskBoard = taskBoardRepository.findById(id);
		if (taskBoard.isPresent()) {
			taskBoardDetails.setId(id);
			return taskBoardRepository.save(taskBoardDetails);
		}
		return null;
	}

	// Delete a task by ID
	public void deleteTask(String id) {
		taskBoardRepository.deleteById(id);
	}
}
