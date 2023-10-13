package hrmsnet.hrms.entities.concretes.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerification;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeVerification"})
public class Employee extends User {

	@Column(name = "first_name")
	@NotBlank(message = "İsim Alanı Boş Bırakılamaz")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Soyisim Alanı Boş Bırakılamaz")
	private String lastName;
	
	@OneToOne(mappedBy = "employee")
	private EmployeeVerification employeeVerification;
}
