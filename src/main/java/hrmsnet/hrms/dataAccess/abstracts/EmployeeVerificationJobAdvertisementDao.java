package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationJobAdvertisement;

public interface EmployeeVerificationJobAdvertisementDao extends JpaRepository<EmployeeVerificationJobAdvertisement, Integer>{

}
