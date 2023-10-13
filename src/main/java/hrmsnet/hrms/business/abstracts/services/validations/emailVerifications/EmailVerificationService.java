package hrmsnet.hrms.business.abstracts.services.validations.emailVerifications;

import hrmsnet.hrms.entities.concretes.users.Employer;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;

public interface EmailVerificationService {
	
	boolean createJobSeekerEmailVerificationCode(JobSeeker jobSeeker);
	
	boolean createEmployerEmailVerificationCode(Employer employer);
}
