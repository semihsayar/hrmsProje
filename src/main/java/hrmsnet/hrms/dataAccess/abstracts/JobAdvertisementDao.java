package hrmsnet.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto;



public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("SELECT NEW hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto(j.id, j.endDate, p.title, e.companyName, ei.imagePath, j.minSalary, j.maxSalary, c.name, j.description, j.freePositionAmount, j.startDate, w.workingTypeName, wp.workingPreferenceName) FROM JobAdvertisement j JOIN j.jobPosition p JOIN j.employer e JOIN e.employerImageInfos ei JOIN j.city c JOIN j.workingType w JOIN j.workingPreference wp WHERE j.status = true AND j.id = :id")
	JobAdvertisementDto getById(int id);
	
	@Query("SELECT NEW hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto(j.id, j.endDate, p.title, e.companyName, ei.imagePath, j.minSalary, j.maxSalary, c.name, j.description, j.freePositionAmount, j.startDate, w.workingTypeName, wp.workingPreferenceName) FROM JobAdvertisement j JOIN j.jobPosition p JOIN j.employer e JOIN e.employerImageInfos ei JOIN j.city c JOIN j.workingType w JOIN j.workingPreference wp WHERE j.status = true AND e.companyName = :companyName")
	List<JobAdvertisementDto> getByCompanyName(String companyName);
	
	@Query("SELECT NEW hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto(j.id, j.endDate, p.title, e.companyName, ei.imagePath, j.minSalary, j.maxSalary, c.name, j.description, j.freePositionAmount, j.startDate, w.workingTypeName, wp.workingPreferenceName) FROM JobAdvertisement j JOIN j.jobPosition p JOIN j.employer e JOIN e.employerImageInfos ei JOIN j.city c JOIN j.workingType w JOIN j.workingPreference wp WHERE j.status = true ORDER BY j.endDate ASC")
    List<JobAdvertisementDto> getAllOrderByEndDateAsc();
	
	@Query("SELECT NEW hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto(j.id, j.endDate, p.title, e.companyName, ei.imagePath, j.minSalary, j.maxSalary, c.name, j.description, j.freePositionAmount, j.startDate, w.workingTypeName, wp.workingPreferenceName) FROM JobAdvertisement j JOIN j.jobPosition p JOIN j.employer e JOIN e.employerImageInfos ei JOIN j.city c JOIN j.workingType w JOIN j.workingPreference wp WHERE j.status = true ORDER BY j.endDate DESC")
    List<JobAdvertisementDto> getAllOrderByEndDateDesc();
	
	@Query("SELECT NEW hrmsnet.hrms.entities.concretes.dtos.JobAdvertisementDto(j.id, j.endDate, p.title, e.companyName, ei.imagePath, j.minSalary, j.maxSalary, c.name, j.description, j.freePositionAmount, j.startDate, w.workingTypeName, wp.workingPreferenceName) FROM JobAdvertisement j JOIN j.jobPosition p JOIN j.employer e JOIN e.employerImageInfos ei JOIN j.city c JOIN j.workingType w JOIN j.workingPreference wp WHERE j.status = true")
	List<JobAdvertisementDto> getJobAdvertisementDtoByStatusTrue();
	
	@Modifying
	@Query("Update JobAdvertisement j set status = false where j.id = :id")
	void updateJobAdvertisementStatus(int id);
}
