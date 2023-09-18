package hrmsnet.hrms.entities.concretes.users;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	
}
