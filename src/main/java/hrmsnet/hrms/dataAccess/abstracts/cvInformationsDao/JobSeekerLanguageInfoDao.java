package hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerLanguageInfo;

public interface JobSeekerLanguageInfoDao extends JpaRepository<JobSeekerLanguageInfo, Integer> {

}
