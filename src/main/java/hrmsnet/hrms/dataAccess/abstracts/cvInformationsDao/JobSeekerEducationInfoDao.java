package hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerEducationInfo;

public interface JobSeekerEducationInfoDao extends JpaRepository<JobSeekerEducationInfo, Integer> {

}
