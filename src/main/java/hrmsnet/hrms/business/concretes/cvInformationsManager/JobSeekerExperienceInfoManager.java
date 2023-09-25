package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerExperienceInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerExperienceInfoDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerExperienceInfo;

@Service
public class JobSeekerExperienceInfoManager implements JobSeekerExperienceInfoService {

	private JobSeekerExperienceInfoDao jobSeekerExperienceInfoDao;
	
	@Autowired
	public JobSeekerExperienceInfoManager(JobSeekerExperienceInfoDao jobSeekerExperienceInfoDao) {
		super();
		this.jobSeekerExperienceInfoDao = jobSeekerExperienceInfoDao;
	}

	@Override
	public Result add(JobSeekerExperienceInfo jobSeekerExperienceInfo) {
		this.jobSeekerExperienceInfoDao.save(jobSeekerExperienceInfo);
		return new SuccessResult("İş Deneyim Bilgisi Kaydedildi");
	}

	@Override
	public DataResult<List<JobSeekerExperienceInfo>> getAll() {
		return new SuccessDataResult<List<JobSeekerExperienceInfo>>(this.jobSeekerExperienceInfoDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobSeekerExperienceInfo>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
		return new SuccessDataResult<List<JobSeekerExperienceInfo>>(this.jobSeekerExperienceInfoDao.findAll(sort),"Data Listelendi");
	}

}
