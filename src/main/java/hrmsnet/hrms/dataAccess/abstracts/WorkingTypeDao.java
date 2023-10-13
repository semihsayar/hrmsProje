package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {

}
