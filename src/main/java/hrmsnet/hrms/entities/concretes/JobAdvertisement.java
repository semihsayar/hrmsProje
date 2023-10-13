package hrmsnet.hrms.entities.concretes;

import java.util.Date;

import hrmsnet.hrms.entities.concretes.users.Employer;
import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationJobAdvertisement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "description", length = 2500)
	private String description;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "status", columnDefinition = "boolean default true")
	private boolean status = true;
	
	@Column(name = "free_position_amount")
	private int freePositionAmount;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "working_preference_id")
	private WorkingPreference workingPreference;
	
	@ManyToOne()
	@JoinColumn(name = "working_type_id")
	private WorkingType workingType;
	
	@OneToOne(mappedBy = "jobAdvertisement")
	private EmployeeVerificationJobAdvertisement employeeVerificationJobAdvertisement;
	
}
