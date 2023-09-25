package hrmsnet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.JobSeekerService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.dtos.JobSeekerCvDto;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/jobseekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeeker>> getAll(){
		
		return this.jobSeekerService.getAll();
	}
	@GetMapping("/getJobSeekerCvDto")
	public DataResult<List<JobSeekerCvDto>> getJobSeekerCvDto(){
		
		return this.jobSeekerService.getJobSeekerCvDto();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobSeeker jobSeeker) {
		
		return this.jobSeekerService.add(jobSeeker);
	}
	
}

