package hrmsnet.hrms.business.abstracts.cvInformationsService;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerWebAddress;

public interface JobSeekerWebAddressService {

	Result add(JobSeekerWebAddress jobSeekerWebAddress);
	
	DataResult<List<JobSeekerWebAddress>> getAll();
	
}
