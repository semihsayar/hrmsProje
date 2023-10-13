package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {

	Result add(WorkingType workingType);
	
	DataResult<List<WorkingType>> getAll();
}
