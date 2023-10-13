package hrmsnet.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {

	private int id;
	private String companyName;
	private String webAddress;
	private String phoneNumber;
	private String email;
	private String password;
}
