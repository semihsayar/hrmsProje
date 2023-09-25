package hrmsnet.hrms.business.abstracts.cvInformationsService;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerEducationInfo;

public interface JobSeekerEducationInfoService {

	Result add(JobSeekerEducationInfo jobSeekerEducationInfo);
	
	DataResult<List<JobSeekerEducationInfo>> getAllSorted();
	
	DataResult<List<JobSeekerEducationInfo>> getAll();
}
