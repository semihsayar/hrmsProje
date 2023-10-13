package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationEmployer;

public interface EmployeeVerificationEmployerDao extends JpaRepository<EmployeeVerificationEmployer, Integer> {

}
