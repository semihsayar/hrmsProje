package hrmsnet.hrms.entities.concretes.cvInformations;

import java.util.Date;

import hrmsnet.hrms.entities.concretes.users.JobSeeker;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seeker_experience_infos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerExperienceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name_of_instutation")
	private String nameOfInstutation;  // Kurum Adı
	
	@Column(name = "role")
	private String role;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date jobStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date jobEndDate;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
}
