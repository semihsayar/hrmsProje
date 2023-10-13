package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.EmployerImageInfo;

public interface EmployerImageInfoDao extends JpaRepository<EmployerImageInfo, Integer> {

}
