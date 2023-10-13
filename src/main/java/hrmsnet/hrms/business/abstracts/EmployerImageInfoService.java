package hrmsnet.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.core.utilities.results.Result;

public interface EmployerImageInfoService {
	
	Result add(MultipartFile file,int employerId);
}
