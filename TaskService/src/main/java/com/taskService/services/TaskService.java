package com.taskService.services;

import java.util.List;

import com.taskService.entities.Task;
import com.taskService.entities.TaskStatus;

public interface TaskService {
	
	Task createTask(Task task,String requestRole) throws Exception;
	
	Task getTaskById(Long Id) throws Exception;
	
	List<Task> getAllTask(TaskStatus status);
	
	Task updateTask(Long id,Task updateTask,Long userId) throws Exception;
	
	void deleteTask(Long id) throws Exception;
	
	Task assignedToUser(Long userId,Long taskId) throws Exception;
	
	List<Task> assignedUsersTask(Long userId,TaskStatus status);
	
	Task completeTask(Long taskId) throws Exception;

}
