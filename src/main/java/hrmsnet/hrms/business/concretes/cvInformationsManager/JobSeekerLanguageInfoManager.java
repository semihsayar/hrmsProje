package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerLanguageInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerLanguageInfoDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerLanguageInfo;

@Service
public class JobSeekerLanguageInfoManager implements JobSeekerLanguageInfoService {

	private JobSeekerLanguageInfoDao jobSeekerLanguageInfoDao;
	
	
	public JobSeekerLanguageInfoManager(JobSeekerLanguageInfoDao jobSeekerLanguageInfoDao) {
		super();
		this.jobSeekerLanguageInfoDao = jobSeekerLanguageInfoDao;
	}

	@Override
	public Result add(JobSeekerLanguageInfo jobSeekerLanguageInfo) {
		this.jobSeekerLanguageInfoDao.save(jobSeekerLanguageInfo);
		return new SuccessResult("Dil Eklendi");
	}

	@Override
	public DataResult<List<JobSeekerLanguageInfo>> getAll() {
		return new SuccessDataResult<List<JobSeekerLanguageInfo>>(this.jobSeekerLanguageInfoDao.findAll());
	}

}
