package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.dtos.JobSeekerCvDto;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	
	Result delete(JobSeeker jobSeeker);
	
	Result update(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<List<JobSeekerCvDto>> getJobSeekerCvDto();
}
