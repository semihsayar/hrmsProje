package hrmsnet.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmsnet.hrms.business.abstracts.EmployerService;
import hrmsnet.hrms.business.services.validations.emailVerifications.EmailVerificationService;
import hrmsnet.hrms.business.services.validations.systemEmployeeVerifications.EmployeeVerificationService;
import hrmsnet.hrms.core.utilities.results.DataResult;
import hrmsnet.hrms.core.utilities.results.ErrorResult;
import hrmsnet.hrms.core.utilities.results.Result;
import hrmsnet.hrms.core.utilities.results.SuccessDataResult;
import hrmsnet.hrms.core.utilities.results.SuccessResult;
import hrmsnet.hrms.dataAccess.abstracts.EmployerDao;
import hrmsnet.hrms.entities.concretes.users.Employer;

@Service
public class EmployerManager implements EmployerService{

	@Autowired
	private EmployerDao employerDao;
	
	@Autowired
	private EmailVerificationService emailVerificationService;
	
	@Autowired
	private EmployeeVerificationService employeeVerificationService;
	
	
	@Override
	public Result add(Employer employer) {
	
		if(!(checkIfEmailExist(employer).isSuccess())) {
			return new ErrorResult("Girdiğiniz Email Kullanımda");
		}
		
		if(!employer.getWebAddress().equals(splitDomainName(employer.getEmail()))) {
			return new ErrorResult("web adresi ile aynı domaina sahip email gerekiyor.");
		}
		
		if(!(checkIfEmailVerified(employer).isSuccess())) {
			return new ErrorResult("Email Doğrulanamadı");
		}
		
		if(!(checkIfEmployeeVerified(employer).isSuccess())) {
			return new ErrorResult("Sistem Çalışanının Onayı Bekleniyor");
		}
		
		this.employerDao.save(employer);
		return new SuccessResult("İş Veren Eklendi");
	}
	

	@Override
	public Result delete(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Data Listelendi");
	}
	
	
	private Result checkIfEmailVerified(Employer employer) {
		
		if (emailVerificationService.createEmployerEmailVerificationCode(employer)) {
			return new SuccessResult();
		}return new ErrorResult();
	
	}
	
	private Result checkIfEmployeeVerified(Employer employer) {
		
		if (employeeVerificationService.createEmployerEmployeeVerification(employer)) {
			return new SuccessResult();
		}return new ErrorResult();
	
	}
	
	private Result checkIfEmailExist(Employer employer) {
		var result = employerDao.findAll();
		
		for (Employer item : result) {
			if (item.getEmail().matches(employer.getEmail())) {
				return new ErrorResult();
			}
		}
		return new SuccessResult();
	}
	
	private String splitDomainName(String str )
	{
		String finalOutput = "";
		String arrayOfStr[] = str.split("@");
		if (arrayOfStr.length == 2) {
			finalOutput = arrayOfStr[1];
		}
		return finalOutput;	
	}

}
