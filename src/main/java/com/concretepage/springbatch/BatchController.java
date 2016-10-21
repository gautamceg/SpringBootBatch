package com.concretepage.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {

	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	private Job createMarkSheet;
	
	@RequestMapping(value="/launch.html")
	public String runJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		launcher.run(createMarkSheet, new JobParameters());
		return "job completed";
	}
	
	@RequestMapping(value="/test")
	public String test(){
		return "up";
	}
}
