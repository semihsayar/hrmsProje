package hrmsnet.hrms.api.controllers.cvInformationsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerImageInfoService;
import hrmsnet.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(value = "api/jobseekerimageinfo")
public class JobSeekerImageInfoController {

	private JobSeekerImageInfoService jobSeekerImageInfoService;

	@Autowired
	public JobSeekerImageInfoController(JobSeekerImageInfoService jobSeekerImageInfoService) {
		super();
		this.jobSeekerImageInfoService = jobSeekerImageInfoService;
	}
	
	@PostMapping("/uploadFile")
	public Result uploadFile(@RequestParam("file") MultipartFile file, @RequestParam int jobSeekerId) {

		return 	jobSeekerImageInfoService.add(file, jobSeekerId) ;
	}
	
	
}
