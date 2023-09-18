package hrmsnet.hrms.business.services.validations.systemEmployeeVerifications;

import hrmsnet.hrms.entities.concretes.users.Employer;

public interface EmployeeVerificationService {

	boolean createEmployerEmployeeVerification(Employer employer);
}
