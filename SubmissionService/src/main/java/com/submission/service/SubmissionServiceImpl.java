package com.submission.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.submission.entities.Submission;
import com.submission.entities.TaskDto;
import com.submission.repositories.SubmissionRepository;

@Service
public class SubmissionServiceImpl implements SubmissionService {
	
	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;

	@Override
	public Submission submitTask(Long taskId, String githubLink, Long userId, String jwt) throws Exception {
		// TODO Auto-generated method stub
		TaskDto task=this.taskService.getTaskById(userId, jwt);
		if(task!=null)
		{
			Submission submission=new Submission();
			submission.setTaskId(taskId);
			submission.setUserId(userId);
			submission.setGithubLink(githubLink);
			submission.setSubmissionTime(LocalDateTime.now());
			return submissionRepository.save(submission);
		}
		throw new Exception("Task not found with id:"+taskId);
	}

	@Override
	public Submission getTaskSubmissionById(Long submissionId) throws Exception {
		// TODO Auto-generated method stub
		
		return submissionRepository.findById(submissionId).orElseThrow(()-> new Exception("Task Submission not found with this Id!!!"));
	}

	@Override
	public List<Submission> getAllTaskSubmissions() {
		// TODO Auto-generated method stub
		return submissionRepository.findAll();
	}

	@Override
	public List<Submission> getTaskSubmissionsByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		return submissionRepository.findByTaskId(taskId);
	}

	@Override
	public Submission acceptDeclineSubmission(Long id, String status) throws Exception {
		// TODO Auto-generated method stub
		Submission submission=getTaskSubmissionById(id);
		submission.setStatus(status);
		if(status.equals("ACCEPT")) {
			taskService.completeTask(submission.getTaskId());
		}
		
		return submissionRepository.save(submission);
	}

}
