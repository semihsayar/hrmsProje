package hrmsnet.hrms.business.abstracts.cvInformationsService;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerTalent;

public interface JobSeekerTalentService {

	Result add(JobSeekerTalent jobSeekerTalent);
	
	DataResult<List<JobSeekerTalent>> getAll();
}
