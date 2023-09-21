package hrmsnet.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.JobAdvertisementService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@GetMapping("/getAllOrderByEndDateDesc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc(){
		return this.jobAdvertisementService.getAllOrderByEndDateDesc();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByCompanyName(companyName);
	}

	@GetMapping("/getAllOrderByEndDateAsc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc(){
		return this.jobAdvertisementService.getAllOrderByEndDateAsc();
	}

	@GetMapping("/getJobAdvertisementDtoByStatusTrue")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue(){
		return this.jobAdvertisementService.getJobAdvertisementDtoByStatusTrue();
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("/updateJobAdvertisementStatus")
	@Transactional
	public Result updateJobAdvertisementStatus(@RequestParam int jobAdvertisementId) {
	    return this.jobAdvertisementService.updateJobAdvertisementStatus(jobAdvertisementId);
	}
	

}
