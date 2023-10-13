package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.users.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
