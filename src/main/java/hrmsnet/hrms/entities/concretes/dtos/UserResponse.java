package hrmsnet.hrms.entities.concretes.dtos;

import hrmsnet.hrms.entities.concretes.users.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private int id;
	private String token;
	
	Role role;
}
