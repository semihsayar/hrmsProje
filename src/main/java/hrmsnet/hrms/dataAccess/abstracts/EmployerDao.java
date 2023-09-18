package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.users.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
