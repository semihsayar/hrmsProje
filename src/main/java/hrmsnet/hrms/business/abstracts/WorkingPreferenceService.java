package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.WorkingPreference;

public interface WorkingPreferenceService {

	Result add(WorkingPreference workingPreference);
	
	DataResult<List<WorkingPreference>> getAll();
}
