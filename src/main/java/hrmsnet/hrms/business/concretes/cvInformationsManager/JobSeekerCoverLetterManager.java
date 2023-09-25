package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerCoverLetterService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerCoverLetterDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerCoverLetter;

@Service
public class JobSeekerCoverLetterManager implements JobSeekerCoverLetterService{

	private JobSeekerCoverLetterDao jobSeekerCoverLetterDao;
	
	@Autowired
	public JobSeekerCoverLetterManager(JobSeekerCoverLetterDao jobSeekerCoverLetterDao) {
		super();
		this.jobSeekerCoverLetterDao = jobSeekerCoverLetterDao;
	}

	@Override
	public Result add(JobSeekerCoverLetter jobSeekerCoverLetter) {
		this.jobSeekerCoverLetterDao.save(jobSeekerCoverLetter);
		return new SuccessResult("Ön Yazı Eklendi");
	}

	@Override
	public DataResult<List<JobSeekerCoverLetter>> getAll() {
		return new SuccessDataResult<List<JobSeekerCoverLetter>>(this.jobSeekerCoverLetterDao.findAll(),"Data Listelendi");
	}

}
