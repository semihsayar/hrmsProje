package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.WorkingPreferenceService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.WorkingPreferenceDao;
import hrmsnet.hrms.entities.concretes.WorkingPreference;

@Service
public class WorkingPreferenceManager implements WorkingPreferenceService {

	private WorkingPreferenceDao workingPreferenceDao;
	
	@Autowired
	public WorkingPreferenceManager(WorkingPreferenceDao workingPreferenceDao) {
		super();
		this.workingPreferenceDao = workingPreferenceDao;
	}

	@Override
	public Result add(WorkingPreference workingPreference) {
		this.workingPreferenceDao.save(workingPreference);
		return new SuccessResult("Çalışma Tercihi Eklendi");
	}

	@Override
	public DataResult<List<WorkingPreference>> getAll() {
		return new SuccessDataResult<List<WorkingPreference>>(this.workingPreferenceDao.findAll(),"Data Listelendi");
	}

}
