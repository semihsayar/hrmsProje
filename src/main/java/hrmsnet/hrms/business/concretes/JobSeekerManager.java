package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.JobSeekerService;
import hrmsnet.hrms.business.abstracts.services.validations.emailVerifications.EmailVerificationService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.ErrorResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsnet.hrms.entities.concretes.dtos.JobSeekerCvDto;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	public JobSeekerManager(EmailVerificationService emailVerificationService, JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao = jobSeekerDao;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {
			return new ErrorResult("Girdiğiniz Tc Kimlik No Kullanımda");
		}
		
		if(jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {
			return new ErrorResult("Girdiğiniz E mail Kullanımda");
		}
		
		if(!(checkIfEmailVerified(jobSeeker).isSuccess())) {
			return new ErrorResult("Email Adresiniz Doğrulanamadı");
		}
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Kayıt Oldu");
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Data Listelendi");
	}
	
	private Result checkIfEmailVerified(JobSeeker jobSeeker) {
		
		if (emailVerificationService.createJobSeekerEmailVerificationCode(jobSeeker)) {
			return new SuccessResult();
		}return new ErrorResult();
	
	}

	@Override
	public DataResult<List<JobSeekerCvDto>> getJobSeekerCvDto() {
		return new SuccessDataResult<List<JobSeekerCvDto>>(this.jobSeekerDao.getJobSeekerCvDto(),"Cv Listelendi");
	}

}
