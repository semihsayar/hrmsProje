package hrmsnet.hrms.entities.concretes.verifications;

import hrmsnet.hrms.entities.concretes.users.JobSeeker;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "verification_code_candidates")
@Getter
@Setter
public class JobSeekerEmailVerification  extends EmailVerification {
	
	
	@OneToOne
	@JoinColumn(name ="candidate_id" )
	@ToString.Exclude	
	private JobSeeker jobSeeker;
}

