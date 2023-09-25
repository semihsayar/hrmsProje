package hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerExperienceInfo;

public interface JobSeekerExperienceInfoDao extends JpaRepository<JobSeekerExperienceInfo, Integer> {

}
