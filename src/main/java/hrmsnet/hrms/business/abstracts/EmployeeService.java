package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.entities.concretes.users.Employee;

public interface EmployeeService {

	Result add(Employee employee);

	DataResult<List<Employee>> getAll();
}
