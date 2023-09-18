package hrmsnet.hrms.entities.concretes.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

	@Column(name = "first_name")
	@NotBlank(message = "İsim Alanı Boş Bırakılamaz")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Soyisim Alanı Boş Bırakılamaz")
	private String lastName;
	
	@Column(name = "identity_number")
	@NotBlank(message = "TC Kimlik Numarası Alanı Boş Bırakılamaz")
	private String identityNumber;
	
	@NotNull
    @Min(1940)
	@Max(1999)
	private int birthYear;
	
}
