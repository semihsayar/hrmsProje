package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmployerEmployeeVerification;

public interface EmployerEmployeeVerificationDao extends JpaRepository<EmployerEmployeeVerification, Integer> {

}
