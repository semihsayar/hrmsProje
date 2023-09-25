package hrmsnet.hrms.api.controllers.cvInformationsController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerLanguageInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerLanguageInfo;

@RestController
@RequestMapping(value = "api/jobseekerlanguageinfo")
public class JobSeekerLanguageInfoController {

	private JobSeekerLanguageInfoService jobSeekerLanguageInfoService;

	public JobSeekerLanguageInfoController(JobSeekerLanguageInfoService jobSeekerLanguageInfoService) {
		super();
		this.jobSeekerLanguageInfoService = jobSeekerLanguageInfoService;
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerLanguageInfo>> getAll(){
		return this.jobSeekerLanguageInfoService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerLanguageInfo jobSeekerLanguageInfo) {
		return this.jobSeekerLanguageInfoService.add(jobSeekerLanguageInfo);
	}
}
