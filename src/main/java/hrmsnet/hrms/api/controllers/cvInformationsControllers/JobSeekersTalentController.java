package hrmsnet.hrms.api.controllers.cvInformationsControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerTalentService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerTalent;

@RestController
@RequestMapping(value="/api/jobseekertalents")
@CrossOrigin
public class JobSeekersTalentController {
	
	private JobSeekerTalentService jobSeekerTalentService;

	@Autowired
	public JobSeekersTalentController(JobSeekerTalentService jobSeekerTalentService) {
		super();
		this.jobSeekerTalentService = jobSeekerTalentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerTalent jobSeekerTalent) {
		return this.jobSeekerTalentService.add(jobSeekerTalent);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerTalent>> getAll(){
		return this.jobSeekerTalentService.getAll();
	}
	

}
