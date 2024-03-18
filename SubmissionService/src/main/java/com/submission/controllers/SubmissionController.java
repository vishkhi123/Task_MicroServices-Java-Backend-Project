package com.submission.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.submission.entities.Submission;
import com.submission.entities.UserDto;
import com.submission.service.SubmissionService;
import com.submission.service.TaskService;
import com.submission.service.UserService;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
	@Autowired
    private SubmissionService submissionService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @PostMapping()
    public ResponseEntity<Submission> submitTask(
            @RequestParam Long task_id,
            @RequestParam String github_link,
            @RequestHeader("Authorization") String jwt) throws Exception {

            UserDto user=userService.getUserProfile(jwt);
            Submission submission = submissionService.submitTask(task_id, github_link, user.getId(), jwt);
            System.out.println("submission - "+submission);
            return new ResponseEntity<>(submission, HttpStatus.CREATED);

    }

    @GetMapping("/{submissionId}")
    public ResponseEntity<Submission> getTaskSubmissionById(@PathVariable Long submissionId) {
        try {
            Submission submission = submissionService.getTaskSubmissionById(submissionId);
            return new ResponseEntity<>(submission, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Submission>> getAllTaskSubmissions() {
        List<Submission> submissions = submissionService.getAllTaskSubmissions();
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Submission>> getTaskSubmissionsByTaskId(@PathVariable Long taskId) {
        List<Submission> submissions = submissionService.getTaskSubmissionsByTaskId(taskId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Submission> acceptOrDeclineTaskSubmission(
            @PathVariable Long id,
            @RequestParam("status")String status) throws Exception {
        Submission submission = submissionService.acceptDeclineSubmission(id,status);

//        if(submission.getStatus().equals("COMPLETE")){
//            taskService.completeTask(submission.getTaskId());
//        }

        return new ResponseEntity<>(submission, HttpStatus.OK);
    }


}
