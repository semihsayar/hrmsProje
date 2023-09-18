package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.JobSeekerEmailVerification;

public interface JobSeekerEmailVerificationDao extends JpaRepository<JobSeekerEmailVerification, Integer> {

}
