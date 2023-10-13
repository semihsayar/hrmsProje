package hrmsnet.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value="/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvertisementDto> getById(@RequestParam int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	@GetMapping("/getallorderbyenddatedesc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc(){
		return this.jobAdvertisementService.getAllOrderByEndDateDesc();
	}
	
	@GetMapping("/getbycompanyname")
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByCompanyName(companyName);
	}

	@GetMapping("/getallorderbyenddateasc")
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc(){
		return this.jobAdvertisementService.getAllOrderByEndDateAsc();
	}

	@GetMapping("/getjobadvertisementdtobystatustrue")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue(){
		return this.jobAdvertisementService.getJobAdvertisementDtoByStatusTrue();
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("/updatejobadvertisementstatus")
	@Transactional
	public Result updateJobAdvertisementStatus(@RequestParam int id) {
	    return this.jobAdvertisementService.updateJobAdvertisementStatus(id);
	}
	

}
