package hrmsnet.hrms.business.abstracts.services.validations.emailVerifications;

import org.springframework.stereotype.Service;

import hrmsnet.hrms.entities.concretes.users.Employer;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean createJobSeekerEmailVerificationCode(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean createEmployerEmailVerificationCode(Employer employer) {
		// TODO Auto-generated method stub
		return true;
	}

}
