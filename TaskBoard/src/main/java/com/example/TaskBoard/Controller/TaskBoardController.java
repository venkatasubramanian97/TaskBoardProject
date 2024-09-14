package com.example.TaskBoard.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskBoard.Model.TaskBoard;
import com.example.TaskBoard.Service.TaskBoardService;

@RestController
@RequestMapping("/api/tasks")
public class TaskBoardController {

	@Autowired
	private TaskBoardService taskBoardService;

	// Get all tasks
	@GetMapping("/gettask")
	public ResponseEntity<Object> getAllTasks() {
		List<TaskBoard> tasks = taskBoardService.getAllTasks();
		if (tasks == null || tasks.isEmpty()) {
			return new ResponseEntity<>("No tasks found", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		}
	}

	// Get a task by ID
	@GetMapping("/gettask/{id}")
	public ResponseEntity<Object> getTaskById(@PathVariable String id) {
		Optional<TaskBoard> task = taskBoardService.getTaskById(id);
		if (task.isPresent()) {
			return new ResponseEntity<>(task.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Task not found with ID: " + id, HttpStatus.NOT_FOUND);
		}
	}

	// Create a new task
	@PostMapping("/creattask")
	public ResponseEntity<Object> createTask(@RequestBody TaskBoard taskBoard) {
		TaskBoard createdTask = taskBoardService.createTask(taskBoard);
		return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	}

	// Update an existing task
	@PutMapping("/updatetask/{id}")
	public ResponseEntity<Object> updateTask(@PathVariable String id, @RequestBody TaskBoard taskBoard) {
		TaskBoard updatedTask = taskBoardService.updateTask(id, taskBoard);
		if (updatedTask != null) {
			return new ResponseEntity<>(updatedTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Task not found with ID: " + id, HttpStatus.NOT_FOUND);
		}
	}

	// Delete a task by ID
	@DeleteMapping("/deletetask/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable String id) {
		Optional<TaskBoard> task = taskBoardService.getTaskById(id);
		if (task.isPresent()) {
			taskBoardService.deleteTask(id);
			return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Task not found with ID: " + id, HttpStatus.NOT_FOUND);
		}
	}
}
