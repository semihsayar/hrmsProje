package hrmsnet.hrms.business.abstracts.services.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsnet.hrms.dataAccess.abstracts.EmployerDao;
import hrmsnet.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsnet.hrms.dataAccess.abstracts.UserDao;
import hrmsnet.hrms.entities.concretes.dtos.EmployeeDto;
import hrmsnet.hrms.entities.concretes.dtos.EmployerDto;
import hrmsnet.hrms.entities.concretes.dtos.JobSeekerDto;
import hrmsnet.hrms.entities.concretes.dtos.UserRequest;
import hrmsnet.hrms.entities.concretes.dtos.UserResponse;
import hrmsnet.hrms.entities.concretes.users.Employee;
import hrmsnet.hrms.entities.concretes.users.Employer;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;
import hrmsnet.hrms.entities.concretes.users.User;
import hrmsnet.hrms.entities.concretes.users.enums.Role;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserDao userDao;
    private final JobSeekerDao jobSeekerDao;
    private final EmployerDao employerDao;
    private final EmployeeDao employeeDao;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerJobSeeker(JobSeekerDto jobSeekerDto) {
        JobSeeker jobSeeker = createJobSeekerFromDto(jobSeekerDto);
        jobSeekerDao.save(jobSeeker);
        return generateUserResponse(jobSeeker);
    }

    public UserResponse registerEmployer(EmployerDto employerDto) {
        Employer employer = createEmployerFromDto(employerDto);
        employerDao.save(employer);
        return generateUserResponse(employer);
    }
    
    public UserResponse registerEmployee(EmployeeDto employeeDto) {
        Employee employee = createEmployeeFromDto(employeeDto);
        employeeDao.save(employee);
        return generateUserResponse(employee);
    }

    public UserResponse authenticate(UserRequest userRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
        User user = userDao.findByEmail(userRequest.getEmail()).orElseThrow();
        return generateUserResponse(user);
    }

    private JobSeeker createJobSeekerFromDto(JobSeekerDto jobSeekerDto) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setFirstName(jobSeekerDto.getFirstName());
        jobSeeker.setLastName(jobSeekerDto.getLastName());
        jobSeeker.setEmail(jobSeekerDto.getEmail());
        jobSeeker.setPassword(passwordEncoder.encode(jobSeekerDto.getPassword()));
        jobSeeker.setIdentityNumber(jobSeekerDto.getIdentityNumber());
        jobSeeker.setRole(Role.CANDIDATE);
        
        return jobSeeker;
    }


    private Employer createEmployerFromDto(EmployerDto employerDto) {
        Employer employer = new Employer();
        employer.setCompanyName(employerDto.getCompanyName());
        employer.setWebAddress(employerDto.getWebAddress());
        employer.setPhoneNumber(employerDto.getPhoneNumber());
        employer.setEmail(employerDto.getEmail());
        employer.setPassword(passwordEncoder.encode(employerDto.getPassword()));
        employer.setRole(Role.EMPLOYER);
        return employer;
    }
    
    private Employee createEmployeeFromDto(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        employee.setRole(Role.EMPLOYEE);
        return employee;
    }

    private UserResponse generateUserResponse(User user) {
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).role(user.getRole()).id(user.getId()).build();
 
    }
}
