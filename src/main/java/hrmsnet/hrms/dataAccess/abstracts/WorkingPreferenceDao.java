package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.WorkingPreference;

public interface WorkingPreferenceDao extends JpaRepository<WorkingPreference, Integer> {

}
