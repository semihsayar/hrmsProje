package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerification;

public interface EmployeeVerificationDao extends JpaRepository<EmployeeVerification, Integer> {

}
