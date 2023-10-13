package hrmsnet.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.business.abstracts.EmployerImageInfoService;
import hrmsnet.hrms.core.utilities.results.Result;

@RestController
@RequestMapping(value="/api/employerimageinfos")
@CrossOrigin
public class EmployerImageInfosController {

	private EmployerImageInfoService employerImageInfoService;

	@Autowired
	public EmployerImageInfosController(EmployerImageInfoService employerImageInfoService) {
		super();
		this.employerImageInfoService = employerImageInfoService;
	}
	
	@PostMapping("/uploadfile")
	public Result uploadFile(@RequestParam("file") MultipartFile file, @RequestParam int employerId) {

		return 	employerImageInfoService.add(file, employerId) ;
	}
	
}
