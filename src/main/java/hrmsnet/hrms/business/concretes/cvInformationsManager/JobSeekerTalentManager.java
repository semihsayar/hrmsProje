package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerTalentService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerTalentDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerTalent;

@Service
public class JobSeekerTalentManager implements JobSeekerTalentService{
	
	private JobSeekerTalentDao jobSeekerTalentDao;

	@Autowired
	public JobSeekerTalentManager(JobSeekerTalentDao jobSeekerTalentDao) {
		super();
		this.jobSeekerTalentDao = jobSeekerTalentDao;
	}

	@Override
	public Result add(JobSeekerTalent jobSeekerTalent) {
		this.jobSeekerTalentDao.save(jobSeekerTalent);
		return new SuccessResult("Teknoloji Eklendi");
	}

	@Override
	public DataResult<List<JobSeekerTalent>> getAll() {
		return new SuccessDataResult<List<JobSeekerTalent>>(this.jobSeekerTalentDao.findAll(),"Data Listelendi");
	}

}
