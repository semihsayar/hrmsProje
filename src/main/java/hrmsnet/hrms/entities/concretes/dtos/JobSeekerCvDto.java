package hrmsnet.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvDto {

	private int id;
	private String schoolName;
	private String departmant;
	private String degree;
	private Date startDate;
	private Date endDate;
	private String nameOfInstutation;
	private String role;
	private Date jobStartDate;
	private Date jobEndDate;
	private String languageName;
	private int languageLevel;
	private String imagePath;
	private String githubLink;
	private String linkedinLink;
	private String knownTechnology;
	private String coverLetter;
}
