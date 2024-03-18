package com.taskService.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskService.entities.Task;
import com.taskService.entities.TaskStatus;
import com.taskService.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	

	@Override
	public Task createTask(Task task, String requestRole) throws Exception {
		// TODO Auto-generated method stub
		if(!requestRole.equals(("ROLE_ADMIN")))
		{
			throw new Exception("Only admin can create task");
		}
		task.setStatus(TaskStatus.PENDING);
		task.setCreatedAt(LocalDateTime.now());
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long Id) throws Exception {
		// TODO Auto-generated method stub
		return taskRepository.findById(Id).orElseThrow(()-> new Exception("Task Not Found!!"));
	}

	@Override
	public List<Task> getAllTask(TaskStatus status) {
		List<Task> allTasks=this.taskRepository.findAll();
		List<Task> filteredTask=allTasks.stream().filter(
				task-> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
				).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return filteredTask;
	}

	@Override
	public Task updateTask(Long id, Task updatedTask, Long userId) throws Exception {
		// TODO Auto-generated method stub
		Task existingTask=getTaskById(id);
		if(updatedTask.getTitle()!=null)
		{
			existingTask.setTitle(updatedTask.getTitle());
		}
		if(updatedTask.getImage()!=null){
            existingTask.setImage(updatedTask.getImage());
        }
        if (updatedTask.getDescription()!=null){
            existingTask.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getStatus()!=null){
            existingTask.setStatus(updatedTask.getStatus());
        }
        if(updatedTask.getDeadLine()!=null){
            existingTask.setDeadLine(updatedTask.getDeadLine());
        }


            return taskRepository.save(existingTask);

		
	}

	@Override
	public void deleteTask(Long id) throws Exception {
		// TODO Auto-generated method stub
		getTaskById(id);
		this.taskRepository.deleteById(id);
		
	}

	@Override
	public Task assignedToUser(Long userId, Long taskId) throws Exception {
		// TODO Auto-generated method stub
		Task task=getTaskById(taskId);
		task.setAssignedUserId(userId);
		task.setStatus(TaskStatus.ASSIGNED);
		return taskRepository.save(task);
	}

	@Override
	public List<Task> assignedUsersTask(Long userId, TaskStatus status) {
		// TODO Auto-generated method stub
		List<Task> allTasks=this.taskRepository.findByAssignedUserId(userId);
		List<Task> filteredTask=allTasks.stream().filter(
				task-> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
				).collect(Collectors.toList());
		return filteredTask;
	}

	@Override
	public Task completeTask(Long taskId) throws Exception {
		// TODO Auto-generated method stub.
		Task task=getTaskById(taskId);
		task.setStatus(TaskStatus.DONE);
		return taskRepository.save(task);
	}

}
