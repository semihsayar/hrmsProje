package hrmsnet.hrms.business.abstracts.cvInformationsService;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerLanguageInfo;

public interface JobSeekerLanguageInfoService {

	Result add(JobSeekerLanguageInfo jobSeekerLanguageInfo);
	
	DataResult<List<JobSeekerLanguageInfo>> getAll();
}
