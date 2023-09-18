package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	Result add(JobPosition jobPosition);
	
	DataResult<List<JobPosition>> getAll();
}
