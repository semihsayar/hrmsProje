package hrmsnet.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {

	private int id;
	private Date endDate;
	private String title;
	private String companyName;
	private String imagePath;
	private int minSalary;
	private int maxSalary;
	private String name;
	private String description;
	private int freePositionAmount;
	private Date startDate;
	private String workingTypeName;
	private String workingPreferenceName;
	
}