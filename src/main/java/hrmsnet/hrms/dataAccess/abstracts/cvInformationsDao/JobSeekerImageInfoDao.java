package hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerImageInfo;

public interface JobSeekerImageInfoDao extends JpaRepository<JobSeekerImageInfo, Integer> {

}
