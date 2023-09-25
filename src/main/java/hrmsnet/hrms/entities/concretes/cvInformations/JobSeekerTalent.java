package hrmsnet.hrms.entities.concretes.cvInformations;

import hrmsnet.hrms.entities.concretes.users.JobSeeker;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "job_seeker_talents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerTalent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "known_technology")
	private String knownTechnology;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
}
