package hrmsnet.hrms.entities.concretes.verifications;

import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_confirm_job_advertisements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVerificationJobAdvertisement extends EmployeeVerification {

	@OneToOne
	@JoinColumn(name = "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
}
