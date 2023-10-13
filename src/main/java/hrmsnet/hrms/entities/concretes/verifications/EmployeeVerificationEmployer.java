package hrmsnet.hrms.entities.concretes.verifications;

import hrmsnet.hrms.entities.concretes.users.Employer;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_confirm_employers")
@Getter
@Setter
public class EmployeeVerificationEmployer extends EmployeeVerification {

	@OneToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
}
