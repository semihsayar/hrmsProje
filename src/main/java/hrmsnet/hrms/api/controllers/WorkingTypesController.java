package hrmsnet.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.WorkingTypeService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping(value="/api/workingtypes")
@CrossOrigin
public class WorkingTypesController {

	private WorkingTypeService workingTypeService;

	public WorkingTypesController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingType workingType) {
		return this.workingTypeService.add(workingType);
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}
	
	
}
