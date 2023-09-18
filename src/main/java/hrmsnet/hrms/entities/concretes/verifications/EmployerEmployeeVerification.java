package hrmsnet.hrms.entities.concretes.verifications;

import hrmsnet.hrms.entities.concretes.users.Employer;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee_confirm_employers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerEmployeeVerification extends EmployeeVerification {

	@OneToOne
	@JoinColumn(name="employer_id")
	@ToString.Exclude
	
	private Employer employer;
}
