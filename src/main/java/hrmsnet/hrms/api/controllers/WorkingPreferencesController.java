package hrmsnet.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.WorkingPreferenceService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.WorkingPreference;

@RestController
@RequestMapping(value="/api/workingpreferences")
@CrossOrigin
public class WorkingPreferencesController {

	private WorkingPreferenceService workingPreferenceService;

	public WorkingPreferencesController(WorkingPreferenceService workingPreferenceService) {
		super();
		this.workingPreferenceService = workingPreferenceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingPreference workingPreference) {
		return this.workingPreferenceService.add(workingPreference);
	}
	
	@GetMapping("/getall")
	DataResult<List<WorkingPreference>> getAll(){
		return this.workingPreferenceService.getAll();
	}
}
