package hrmsnet.hrms.entities.concretes.users;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrmsnet.hrms.entities.concretes.EmployerImageInfo;
import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationEmployer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements","employerImageInfos","employeeVerificationEmployer"})
public class Employer extends User {
	
	@Column(name = "company_name")
	@NotBlank(message = "Şirket Adı Alanı Boş Bırakılamaz")
	private String companyName;
	
	@Column(name = "web_address")
	@NotBlank(message = "Web Adres Alanı Boş Bırakılamaz")
	private String webAddress;
	
	@Column(name = "phone_number")
	@NotBlank(message = "Telefon Numarası Alanı Boş Bırakılamaz")
	private String phoneNumber;
	
	@OneToMany(mappedBy ="employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToMany(mappedBy = "employer")
	private List<EmployerImageInfo> employerImageInfos;
	
	@OneToOne(mappedBy = "employer")
	private EmployeeVerificationEmployer employeeVerificationEmployer;
	
	
}
