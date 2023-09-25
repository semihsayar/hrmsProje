package hrmsnet.hrms.business.concretes.cvInformationsManager;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.business.abstracts.cvInformationsService.JobSeekerImageInfoService;
import hrmsnet.hrms.business.abstracts.services.storage.FileOperations;
import hrmsnet.hrms.business.abstracts.services.storage.FileService;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.JobSeekerDao;
import hrmsnet.hrms.dataAccess.abstracts.cvInformationsDao.JobSeekerImageInfoDao;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerImageInfo;

@Service
public class JobSeekerImageInfoManager implements JobSeekerImageInfoService {
	
	private JobSeekerImageInfoDao jobSeekerImageInfoDao;
	private FileService fileService;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerImageInfoManager(JobSeekerImageInfoDao jobSeekerImageInfoDao, FileService fileService,
			JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerImageInfoDao = jobSeekerImageInfoDao;
		this.fileService = fileService;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(MultipartFile file, int jobSeekerId) {
		JobSeekerImageInfo jobSeekerImageInfo = new JobSeekerImageInfo();
		
		try {
			String filePath= fileService.uploadFile(file);
			jobSeekerImageInfo.setJobSeeker(jobSeekerDao.findById(jobSeekerId).orElseThrow());
			jobSeekerImageInfo.setImageName(FileOperations.getFileName(file));
			jobSeekerImageInfo.setStorageName(fileService.getFileStorageName());
			jobSeekerImageInfo.setImagePath(filePath);
			
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		jobSeekerImageInfoDao.save(jobSeekerImageInfo);
		
		return new SuccessResult("Profil resminiz başarılı bir şekilde kaydedildi");
	}	

}
