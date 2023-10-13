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
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_seeker_education_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerEducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "departmant")
	private String departmant;
	
	@Column(name = "degree")
	private String degree;
	
	@PastOrPresent	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@PastOrPresent	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	
}
