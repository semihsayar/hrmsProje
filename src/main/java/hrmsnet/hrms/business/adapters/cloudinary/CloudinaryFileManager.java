package hrmsnet.hrms.business.adapters.cloudinary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrmsnet.hrms.business.abstracts.services.storage.FileOperations;
import hrmsnet.hrms.business.abstracts.services.storage.FileService;
import hrmsnet.hrms.entities.concretes.cvInformations.enums.StorageType;

@Service
public class CloudinaryFileManager implements FileService {

	@Autowired
	private Environment environment;

	@Override
	public String uploadFile(MultipartFile file) {


		// ...

		// Cloudinary konfigürasyonunu yapılandırın
		Map<String, String> config = new HashMap<>();
		config.put("cloud_name", environment.getProperty("cloudinary.cloud_name"));
		config.put("api_key", environment.getProperty("cloudinary.api_key"));
		config.put("api_secret", environment.getProperty("cloudinary.api_secret"));

		// Cloudinary nesnesini oluşturun
		Cloudinary cloudinary = new Cloudinary(config);

		// Dosya yükleme işlemi
		String fileNameWithExtension = FileOperations.getFileNameWithExtension(file);
		String fileName = FileOperations.getFileName(file);
		byte[] fileBytes = FileOperations.getFileBytes(file);
		String filePath = environment.getProperty("cloudinary.file_folder_name") + fileName;

		Object imageVersion = "";

		try {
		    // Dosyayı yükleyin ve yükleme sonucunu alın
		    Map<?, ?> uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap("public_id", filePath));
		    imageVersion = uploadResult.get("version"); // Resim sürümünü alın
		} catch (IOException exception) {
		    System.out.println(exception.getMessage());
		}

		// Dosyanın tam URL'sini oluşturun
		String fileFullPath = cloudinary.url().resourceType("image").generate(filePath);

		return fileFullPath;

	}

	@Override
	public StorageType getFileStorageName() {
		
		return StorageType.Cloudinary;
	}

}
