package hrmsnet.hrms.business.abstracts.services.validations.employeeVerifications;

import java.util.Date;

import org.springframework.stereotype.Service;

import hrmsnet.hrms.dataAccess.abstracts.EmployeeDao;
import hrmsnet.hrms.dataAccess.abstracts.EmployeeVerificationEmployerDao;
import hrmsnet.hrms.dataAccess.abstracts.EmployeeVerificationJobAdvertisementDao;
import hrmsnet.hrms.dataAccess.abstracts.EmployerDao;
import hrmsnet.hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrmsnet.hrms.entities.concretes.JobAdvertisement;
import hrmsnet.hrms.entities.concretes.users.Employee;
import hrmsnet.hrms.entities.concretes.users.Employer;
import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationEmployer;
import hrmsnet.hrms.entities.concretes.verifications.EmployeeVerificationJobAdvertisement;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService {
	
	private final EmployeeDao employeeDao;
	private final EmployerDao employerDao;
	private final JobAdvertisementDao jobAdvertisementDao;
	private final EmployeeVerificationEmployerDao employeeVerificationEmployerDao;
	private final EmployeeVerificationJobAdvertisementDao employeeVerificationJobAdvertisementDao;
	
	public EmployeeVerificationManager(EmployeeDao employeeDao, EmployerDao employerDao,
			JobAdvertisementDao jobAdvertisementDao, EmployeeVerificationEmployerDao employeeVerificationEmployerDao,
			EmployeeVerificationJobAdvertisementDao employeeVerificationJobAdvertisementDao) {
		super();
		this.employeeDao = employeeDao;
		this.employerDao = employerDao;
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employeeVerificationEmployerDao = employeeVerificationEmployerDao;
		this.employeeVerificationJobAdvertisementDao = employeeVerificationJobAdvertisementDao;
	}

	@Override
	public void verificationEmployer(int employeeId, int employerId) {
		EmployeeVerificationEmployer employeeVerificationEmployer = new EmployeeVerificationEmployer();
		
		Employee employee = employeeDao.findById(employeeId).orElseThrow(() -> new RuntimeException("Sistem Çalışanı Bulunamadı!"));
		Employer employer = employerDao.findById(employerId).orElseThrow(() -> new RuntimeException("İş Veren Bulunamadı!"));
		
		employeeVerificationEmployer.setConfirmed(true);
		employeeVerificationEmployer.setConfirmDate(new Date());
		employeeVerificationEmployer.setEmployee(employee);
		employeeVerificationEmployer.setEmployer(employer);
		
		employeeVerificationEmployerDao.save(employeeVerificationEmployer);
		
	}

	@Override
	public void verificationJobAdvertisement(int employeeId, int jobAdvertisementId) {
		EmployeeVerificationJobAdvertisement employeeVerificationJobAdvertisement = new EmployeeVerificationJobAdvertisement();
		
		Employee employee = employeeDao.findById(employeeId).orElseThrow();
		JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(jobAdvertisementId).orElseThrow();
		
		employeeVerificationJobAdvertisement.setConfirmed(true);
		employeeVerificationJobAdvertisement.setConfirmDate(new Date());
		employeeVerificationJobAdvertisement.setEmployee(employee);
		employeeVerificationJobAdvertisement.setJobAdvertisement(jobAdvertisement);
		jobAdvertisement.setStatus(true);
		
		employeeVerificationJobAdvertisementDao.save(employeeVerificationJobAdvertisement);
		
	}

}
