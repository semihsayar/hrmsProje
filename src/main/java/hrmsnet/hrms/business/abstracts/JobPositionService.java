package hrmsnet.hrms.business.abstracts;

import java.util.List;

import hrmsnet.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAll();
}
