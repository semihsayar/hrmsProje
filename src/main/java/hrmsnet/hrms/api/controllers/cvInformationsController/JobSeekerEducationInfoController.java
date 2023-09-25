package hrmsnet.hrms.api.controllers.cvInformationsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerEducationInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerEducationInfo;

@RestController
@RequestMapping(value = "api/JobSeekerEducationInfo")
public class JobSeekerEducationInfoController {
	
	private JobSeekerEducationInfoService jobSeekerEducationInfoService;

	@Autowired
	public JobSeekerEducationInfoController(JobSeekerEducationInfoService jobSeekerEducationInfoService) {
		super();
		this.jobSeekerEducationInfoService = jobSeekerEducationInfoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerEducationInfo jobSeekerEducationInfo) {
		return this.jobSeekerEducationInfoService.add(jobSeekerEducationInfo);	
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobSeekerEducationInfo>> getAllSorted(){
		return this.jobSeekerEducationInfoService.getAllSorted();
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerEducationInfo>> getAll(){
		return this.jobSeekerEducationInfoService.getAll();
	}

}
