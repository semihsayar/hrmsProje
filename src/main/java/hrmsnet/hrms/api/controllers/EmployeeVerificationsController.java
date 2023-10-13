package hrmsnet.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.services.validations.employeeVerifications.EmployeeVerificationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/employeeverification")
@RequiredArgsConstructor
public class EmployeeVerificationsController {

	private final EmployeeVerificationService employeeVerificationService;
	
	@PostMapping("/verificationemployer")
	public void verificationEmployer(@RequestParam int employeeId, @RequestParam int employerId) {
		this.employeeVerificationService.verificationEmployer(employeeId, employerId);
	}
	
	@PostMapping("/verificationjobadvertisement")
	public void verificationJobAdvertisement(@RequestParam int employeeId, @RequestParam int jobAdvertisementId) {
		this.employeeVerificationService.verificationJobAdvertisement(employeeId, jobAdvertisementId);
	}
	
	
}
