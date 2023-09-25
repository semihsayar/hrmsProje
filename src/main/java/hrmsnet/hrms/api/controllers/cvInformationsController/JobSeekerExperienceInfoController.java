package hrmsnet.hrms.api.controllers.cvInformationsController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerExperienceInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerExperienceInfo;

@RestController
@RequestMapping(value = "api/jobseekerExperienceinfo")
public class JobSeekerExperienceInfoController {

	private JobSeekerExperienceInfoService jobSeekerExperienceInfoService;

	public JobSeekerExperienceInfoController(JobSeekerExperienceInfoService jobSeekerExperienceInfoService) {
		super();
		this.jobSeekerExperienceInfoService = jobSeekerExperienceInfoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerExperienceInfo jobSeekerExperienceInfo) {
		
		return jobSeekerExperienceInfoService.add(jobSeekerExperienceInfo);
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerExperienceInfo>> getAll(){
		return jobSeekerExperienceInfoService.getAll();
	}
	
	@GetMapping("/getAllSortedDesc")
	public DataResult<List<JobSeekerExperienceInfo>> getAllSorted(){
		return this.jobSeekerExperienceInfoService.getAllSorted();
	}
	
}
