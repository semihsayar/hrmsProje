package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmailVerification;

public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {

}
