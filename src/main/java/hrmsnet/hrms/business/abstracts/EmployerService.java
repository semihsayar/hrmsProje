package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.users.Employer;

public interface EmployerService {

	Result add(Employer employer);
	
	Result delete(Employer employer);
	
	Result update(Employer employer);
	
	DataResult<List<Employer>> getAll();
}
