package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<JobAdvertisementDto> getById(int id);
	
	DataResult<List<JobAdvertisementDto>> getByCompanyName(String companyName);
	
	DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc();
	
	DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc();

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue();
	
	DataResult<List<JobAdvertisement>> getAll();
	
	Result updateJobAdvertisementStatus(int id);
	
}
