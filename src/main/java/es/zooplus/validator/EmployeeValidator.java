package es.zooplus.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import es.zooplus.entity.EmployeeEntityForm;
import es.zooplus.service.EmployeeManager;

public class EmployeeValidator {
	
	@Autowired
	private EmployeeManager employeeManager;
	
	public boolean supports(Class clazz) {
		return EmployeeEntityForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) 
	{   
		// Check null values and white spaces on fields
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "User name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password", "Password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordconf", "error.passwordconf", "Confirmation password is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.firstname", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.lastname", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdateday", "error.birthdateday", "Birthdate day is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdatemonth", "error.birthdatemonth", "Birthdate month is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdateyear", "error.birthdateyear", "Birthdate year is required.");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.address", "Address is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.city", "City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.zip", "City is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephone", "error.telephone", "Telephone is required.");
		
		// Check email is RFC compliant
		
		EmployeeEntityForm employeeEntityForm =  (EmployeeEntityForm) target;
		
		String email = employeeEntityForm.getEmail();
		
		if (email.isEmpty()==false){
           boolean email_ok = true;
           try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
           } catch (AddressException ex) {
                   email_ok = false;
           }
           if (email_ok == false)
        	  errors.rejectValue("email", "error.emailnotrfc");
		}
		
		// Check pass and conf are equal
		
        if (employeeEntityForm.getPassword().isEmpty() == false && employeeEntityForm.getPasswordconf().isEmpty() == false &&	
        		employeeEntityForm.getPassword().equals(employeeEntityForm.getPasswordconf()) == false)
           errors.rejectValue("password", "error.passwordconfdiff");
        
        // Check user name has not been selected
        
		if (employeeEntityForm.getUsername().isEmpty() == false && employeeManager.findEmployee(employeeEntityForm.getUsername())>0)
			errors.rejectValue("username", "error.usernameselected");
		
		// Check birthdate
		
		if (employeeEntityForm.getBirthdateyear().isEmpty() == false &&
			employeeEntityForm.getBirthdatemonth().isEmpty() == false &&
			employeeEntityForm.getBirthdateday().isEmpty() == false){
			
		
		    try {
			     String date_to_validate = employeeEntityForm.getBirthdateyear()+"-"+employeeEntityForm.getBirthdatemonth()+"-"+employeeEntityForm.getBirthdateday();
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			     sdf.setLenient(false);
			     Date date = sdf.parse(date_to_validate);
		    } catch (ParseException e) {
			
			      errors.rejectValue("birthdateday", "error.birthdatedate");
		      }
		}
	}

}
