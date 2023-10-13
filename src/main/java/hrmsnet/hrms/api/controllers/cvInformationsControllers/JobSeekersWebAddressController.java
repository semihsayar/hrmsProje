package hrmsnet.hrms.api.controllers.cvInformationsControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerWebAddressService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerWebAddress;

@RestController
@RequestMapping(value="/api/jobseekerwebaddress")
@CrossOrigin
public class JobSeekersWebAddressController {

	private JobSeekerWebAddressService jobSeekerWebAddressService;

	@Autowired
	public JobSeekersWebAddressController(JobSeekerWebAddressService jobSeekerWebAddressService) {
		super();
		this.jobSeekerWebAddressService = jobSeekerWebAddressService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobSeekerWebAddress>> getAll(){
		return this.jobSeekerWebAddressService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekerWebAddress jobSeekerWebAddress) {
		return this.jobSeekerWebAddressService.add(jobSeekerWebAddress);
	}
}
