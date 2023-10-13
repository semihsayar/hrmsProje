package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.EmployeeService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsnet.hrms.entities.concretes.users.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private final EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Sistem Çalışanı Eklendi");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
