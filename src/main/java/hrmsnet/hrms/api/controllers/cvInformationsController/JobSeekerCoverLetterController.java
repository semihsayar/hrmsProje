package hrmsnet.hrms.api.controllers.cvInformationsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerCoverLetterService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerCoverLetter;

@RestController
@RequestMapping(value = "/api/jobseekercoverletter")
public class JobSeekerCoverLetterController {

	private JobSeekerCoverLetterService jobSeekerCoverLetterService;

	@Autowired
	public JobSeekerCoverLetterController(JobSeekerCoverLetterService jobSeekerCoverLetterService) {
		super();
		this.jobSeekerCoverLetterService = jobSeekerCoverLetterService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerCoverLetter>> getAll(){
		return this.jobSeekerCoverLetterService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerCoverLetter jobSeekerCoverLetter) {
		return this.jobSeekerCoverLetterService.add(jobSeekerCoverLetter);	
}
	
	
}
