package hrmsnet.hrms.business.abstracts.services.storage;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import hrmsnet.hrms.entities.concretes.cvInformations.enums.StorageType;

public interface FileService {

	String uploadFile(MultipartFile file) throws IOException;
	StorageType getFileStorageName();
}
