package hrmsnet.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
