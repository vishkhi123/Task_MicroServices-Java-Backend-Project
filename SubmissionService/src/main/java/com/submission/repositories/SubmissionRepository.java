package com.submission.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.submission.entities.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long>  {
	
	List<Submission> findByTaskId(Long taskId);
	

}
