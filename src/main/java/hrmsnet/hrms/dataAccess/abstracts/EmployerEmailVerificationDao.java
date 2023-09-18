package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmployerEmailVerification;

public interface EmployerEmailVerificationDao extends JpaRepository<EmployerEmailVerification, Integer> {

}
