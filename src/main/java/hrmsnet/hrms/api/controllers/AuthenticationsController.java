package hrmsnet.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmsnet.hrms.business.abstracts.services.security.AuthenticationService;
import hrmsnet.hrms.entities.concretes.dtos.EmployeeDto;
import hrmsnet.hrms.entities.concretes.dtos.EmployerDto;
import hrmsnet.hrms.entities.concretes.dtos.JobSeekerDto;
import hrmsnet.hrms.entities.concretes.dtos.UserRequest;
import hrmsnet.hrms.entities.concretes.dtos.UserResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/authentications")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationsController {
	
	private final AuthenticationService authenticationService;
	
	@PostMapping("/registerjobseeker")
    public ResponseEntity<UserResponse> registerJobSeeker(@RequestBody JobSeekerDto jobSeekerDto) {
        return ResponseEntity.ok(authenticationService.registerJobSeeker(jobSeekerDto));
    }
	
	@PostMapping("/registeremployer")
    public ResponseEntity<UserResponse> registerEmployer(@RequestBody EmployerDto employerDto) {
        return ResponseEntity.ok(authenticationService.registerEmployer(employerDto));
    }
	
	@PostMapping("/registeremployee")
    public ResponseEntity<UserResponse> registerEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(authenticationService.registerEmployee(employeeDto));
    }
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> auth(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(userRequest));
    }

}
