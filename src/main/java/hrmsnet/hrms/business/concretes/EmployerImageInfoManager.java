package hrmsnet.hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.business.abstracts.EmployerImageInfoService;
import hrmsnet.hrms.business.abstracts.services.storage.FileOperations;
import hrmsnet.hrms.business.abstracts.services.storage.FileService;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.EmployerDao;
import hrmsnet.hrms.dataAccess.abstracts.EmployerImageInfoDao;
import hrmsnet.hrms.entities.concretes.EmployerImageInfo;

@Service
public class EmployerImageInfoManager implements EmployerImageInfoService {

	private EmployerImageInfoDao employerImageInfoDao;
	private FileService fileService;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerImageInfoManager(EmployerImageInfoDao employerImageInfoDao, FileService fileService,
			EmployerDao employerDao) {
		super();
		this.employerImageInfoDao = employerImageInfoDao;
		this.fileService = fileService;
		this.employerDao = employerDao;
	}




	@Override
	public Result add(MultipartFile file, int employerId) {
		EmployerImageInfo employerImageInfo = new EmployerImageInfo();
		
		try {
			String filePath= fileService.uploadFile(file);
			employerImageInfo.setEmployer(employerDao.findById(employerId).orElseThrow());
			employerImageInfo.setImageName(FileOperations.getFileName(file));
			employerImageInfo.setStorageName(fileService.getFileStorageName());
			employerImageInfo.setImagePath(filePath);
			
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		
		employerImageInfoDao.save(employerImageInfo);
		
		return new SuccessResult("Şirket Profil resminiz başarılı bir şekilde kaydedildi");
	}

}
