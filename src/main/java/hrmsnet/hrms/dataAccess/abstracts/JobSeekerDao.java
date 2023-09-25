package hrmsnet.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrmsnet.hrms.entities.concretes.dtos.JobSeekerCvDto;
import hrmsnet.hrms.entities.concretes.users.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findByEmail(String name);
	
	JobSeeker findByIdentityNumber(String name);
	
	@Query("SELECT new hrmsnet.hrms.entities.concretes.dtos.JobSeekerCvDto(js.id, j.schoolName, j.departmant, j.degree, j.startDate, j.endDate, je.nameOfInstutation, je.role, je.jobStartDate, je.jobEndDate, jl.languageName,jl.languageLevel, ji.imagePath, jw.githubLink, jw.linkedinLink, jt.knownTechnology, jc.coverLetter) FROM JobSeeker js JOIN js.jobSeekerEducationInfos j JOIN js.jobSeekerExperienceInfos je JOIN js.jobSeekerLanguageInfos jl JOIN js.jobSeekerImageInfos ji JOIN js.jobSeekerWebAddress jw JOIN js.jobSeekerTalents jt JOIN js.jobSeekerCoverLetters jc")
	List<JobSeekerCvDto> getJobSeekerCvDto();
}
