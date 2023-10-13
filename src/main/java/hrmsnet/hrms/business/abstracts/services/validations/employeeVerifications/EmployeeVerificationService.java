package hrmsnet.hrms.business.abstracts.services.validations.employeeVerifications;

public interface EmployeeVerificationService {

	void verificationEmployer(int employeeId, int employerId);
	void verificationJobAdvertisement(int employeeId, int jobAdvertisementId);
	
}
