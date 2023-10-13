package hrmsnet.hrms.entities.concretes;

import hrmsnet.hrms.entities.concretes.cvInformations.enums.StorageType;
import hrmsnet.hrms.entities.concretes.users.Employer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_image_infos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerImageInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "storage_name")
	@Enumerated(EnumType.STRING)
	private StorageType storageName;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
