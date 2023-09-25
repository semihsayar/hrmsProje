package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerWebAddressService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerWebAddressDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerWebAddress;

@Service
public class JobSeekerWebAddressManager implements JobSeekerWebAddressService{

	private JobSeekerWebAddressDao jobSeekerWebAddressDao;
	
	@Autowired
	public JobSeekerWebAddressManager(JobSeekerWebAddressDao jobSeekerWebAddressDao) {
		super();
		this.jobSeekerWebAddressDao = jobSeekerWebAddressDao;
	}

	@Override
	public Result add(JobSeekerWebAddress jobSeekerWebAddress) {
		this.jobSeekerWebAddressDao.save(jobSeekerWebAddress);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<JobSeekerWebAddress>> getAll() {
		return new SuccessDataResult<List<JobSeekerWebAddress>>(this.jobSeekerWebAddressDao.findAll(),"Data Listelendi");
	}

}
