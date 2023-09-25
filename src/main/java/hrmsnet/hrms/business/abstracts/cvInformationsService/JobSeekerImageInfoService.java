package hrmsnet.hrms.business.abstracts.cvInformationsService;

import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.core.utilities.results.Result;

public interface JobSeekerImageInfoService {

	Result add(MultipartFile file,int jobSeekerId);
}
