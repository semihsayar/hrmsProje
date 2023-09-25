package hrmsnet.hrms.entities.concretes.users;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerCoverLetter;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerEducationInfo;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerExperienceInfo;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerImageInfo;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerLanguageInfo;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerTalent;
import hrmsnet.hrms.entities.concretes.cvInformations.JobSeekerWebAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerEducationInfos","jobSeekerExperienceInfos","jobSeekerLanguageInfos","jobSeekerImageInfos","jobSeekerWebAddress","jobSeekerTalents","jobSeekerCoverLetters"})
public class JobSeeker extends User {

	@Column(name = "first_name")
	@NotBlank(message = "İsim Alanı Boş Bırakılamaz")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Soyisim Alanı Boş Bırakılamaz")
	private String lastName;
	
	@Column(name = "identity_number")
	@NotBlank(message = "TC Kimlik Numarası Alanı Boş Bırakılamaz")
	private String identityNumber;
	
	@NotNull
    @Min(1940)
	@Max(1999)
	private int birthYear;
	
	@OneToMany(mappedBy = "jobSeeker" )
	private List<JobSeekerEducationInfo> jobSeekerEducationInfos;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerExperienceInfo> jobSeekerExperienceInfos;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLanguageInfo> jobSeekerLanguageInfos;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerImageInfo> jobSeekerImageInfos;
	
	@OneToOne(mappedBy = "jobSeeker")
	private JobSeekerWebAddress jobSeekerWebAddress;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerTalent> jobSeekerTalents;
	
	@OneToOne(mappedBy = "jobSeeker")
	private JobSeekerCoverLetter jobSeekerCoverLetters;
	
	
	
}
