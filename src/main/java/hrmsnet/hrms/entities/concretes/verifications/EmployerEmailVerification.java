package hrmsnet.hrms.entities.concretes.verifications;

import hrmsnet.hrms.entities.concretes.users.Employer;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "verification_code_employers")
@Getter
@Setter
public class EmployerEmailVerification  extends EmailVerification {

	@OneToOne
	@JoinColumn(name="employer_id")
	@ToString.Exclude
	
	private Employer employer;
	
}
