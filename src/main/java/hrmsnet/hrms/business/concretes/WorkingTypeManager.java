package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.WorkingTypeService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.WorkingTypeDao;
import hrmsnet.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{

	private WorkingTypeDao workingTypeDao;

	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResult("Çalışma Şekli Eklendi");
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll(),"Data Listelendi");
	}
	
	
}
