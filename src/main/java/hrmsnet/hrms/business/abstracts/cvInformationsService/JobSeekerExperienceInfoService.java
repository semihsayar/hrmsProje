package hrmsnet.hrms.business.abstracts.cvInformationsService;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerExperienceInfo;

public interface JobSeekerExperienceInfoService {

	Result add(JobSeekerExperienceInfo jobSeekerExperienceInfo);
	
	DataResult<List<JobSeekerExperienceInfo>> getAll();
	
	DataResult<List<JobSeekerExperienceInfo>> getAllSorted();
}
