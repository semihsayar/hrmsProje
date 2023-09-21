package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.JobAdvertisementService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDtoByStatusTrue() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDtoByStatusTrue(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
	
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateAsc() {
		
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllOrderByEndDateAsc(),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getByCompanyName(companyName),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getAllOrderByEndDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllOrderByEndDateDesc(),"Data Listelendi");
	}

	@Override
	public Result updateJobAdvertisementStatus(int jobAdvertisementId) {
		this.jobAdvertisementDao.updateJobAdvertisementStatus(jobAdvertisementId);
		return new SuccessResult("İş İlanı Pasif Duruma Getirildi") ;
	}

	


}
