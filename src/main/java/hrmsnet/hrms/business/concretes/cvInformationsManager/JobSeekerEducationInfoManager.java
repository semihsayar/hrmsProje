package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerEducationInfoService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerEducationInfoDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerEducationInfo;

@Service
public class JobSeekerEducationInfoManager implements JobSeekerEducationInfoService{

	private JobSeekerEducationInfoDao jobSeekerEducationInfoDao;
	
	@Autowired
	public JobSeekerEducationInfoManager(JobSeekerEducationInfoDao jobSeekerEducationInfoDao) {
		super();
		this.jobSeekerEducationInfoDao = jobSeekerEducationInfoDao;
	}


	@Override
	public Result add(JobSeekerEducationInfo jobSeekerEducationInfo) {
		this.jobSeekerEducationInfoDao.save(jobSeekerEducationInfo);

		return new SuccessResult("Okul Bilgileri Eklendi");
	}


	@Override
	public DataResult<List<JobSeekerEducationInfo>> getAllSorted() {	
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");
		
		return new SuccessDataResult<List<JobSeekerEducationInfo>>(this.jobSeekerEducationInfoDao.findAll(sort),"Data Listelendi");
	}


	@Override
	public DataResult<List<JobSeekerEducationInfo>> getAll() {
		return new SuccessDataResult<List<JobSeekerEducationInfo>>(this.jobSeekerEducationInfoDao.findAll(),"Data Listelendi");
	}
	
}
