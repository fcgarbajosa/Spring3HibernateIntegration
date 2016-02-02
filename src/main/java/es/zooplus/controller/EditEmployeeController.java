package es.zooplus.controller;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.zooplus.entity.EmployeeEntity;
import es.zooplus.entity.EmployeeEntityForm;
import es.zooplus.entity.User_currenciesEntity;
import es.zooplus.service.EmployeeManager;
import es.zooplus.service.User_currenciesManager;
import es.zooplus.validator.EmployeeValidator;

@Controller
public class EditEmployeeController {

	@Autowired
	private EmployeeManager employeeManager;
    
	@Autowired
	private User_currenciesManager user_currenciesManager;

	@Autowired
	EmployeeValidator validator;
	
	private User_currenciesEntity user_currencies;	
	
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
    
	// Redirections made by the controller:
	
	// Home. Redirected to currencies home for this user. If not identified it will be redirected to login 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/list";
	}
	
	// Currencies home. Currencies list for that user
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUser_currencies(ModelMap map) {
		
	    map.addAttribute("user_currencies", new User_currenciesEntity());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();   
        Integer current_user_id = employeeManager.findEmployee(currentPrincipalName);
        map.addAttribute("user_currenciesList", user_currenciesManager.getAllUser_currencies(current_user_id));
		         
		return "editEmployeeList";
	}
    
	// Add currencies element to database for that user
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(ModelMap map) {		
        user_currencies = new User_currenciesEntity();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();   
        Integer current_user_id = employeeManager.findEmployee(currentPrincipalName);
		user_currencies.setId_user(current_user_id);

        
		try {
			
			// Get currencies values
			
			URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=d350e93f872342e3bcca12605841be0d");
	        BufferedInputStream bis = new BufferedInputStream(url.openStream());
	        byte[] buffer = new byte[40000];
	        
	        bis.read(buffer);
	        String str1 = new String(buffer, "UTF-8");
	        
	        JSONObject obj = new JSONObject(str1);
	        Double euro = obj.getJSONObject("rates").getDouble("EUR");
            String euro_string = euro.toString();
	        Double ps = obj.getJSONObject("rates").getDouble("GBP");
            String ps_string = ps.toString();
	        Double yen = obj.getJSONObject("rates").getDouble("JPY");
            String yen_string = yen.toString();
    		user_currencies.setEuro(euro_string);
    		user_currencies.setSp(ps_string);
    		user_currencies.setYen(yen_string);
    		Date date = new Date();
    		
    		user_currencies.setTime_created(date);
    	    user_currenciesManager.addUser_currencies(user_currencies);
	        
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	        
		return "redirect:/list";
	}
    
	// Delete currencies element
	
	@RequestMapping("/delete/{user_currenciesId}")
	public String deleteUser_currency(@PathVariable("user_currenciesId") Integer user_currenciesId) {

		user_currenciesManager.deleteUser_currencies(user_currenciesId);
		return "redirect:/list";
	}

	// Login
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
    
	// Access denied 
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
    
	// Logout
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
    
	// Register screen. Unprotected
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
	     model.addAttribute("employeeForm", new EmployeeEntityForm());
		return "register";
	}
    
	// Add registered user to the database
	
	@RequestMapping(value = "/add_register", method = RequestMethod.POST)
	public String addEmployeeRegister(
			@ModelAttribute(value = "employeeForm") EmployeeEntityForm employeeEntityForm,
			BindingResult result) {
        
		// Validate fields
		
		validator.validate(employeeEntityForm, result);
		
		// if Errors go back to register screen
		
		if (result.hasErrors()) {
			return "register";
		}	
		
		// Insert registered user
		
		EmployeeEntity employee = new EmployeeEntity();
		employee.setUsername(employeeEntityForm.getUsername());
		employee.setPassword(employeeEntityForm.getPassword());
		employee.setFirstname(employeeEntityForm.getFirstname());
		employee.setLastname(employeeEntityForm.getLastname());
		

		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			date = sdf.parse(employeeEntityForm.getBirthdateyear()+"-"+employeeEntityForm.getBirthdatemonth()+"-"+employeeEntityForm.getBirthdateday());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employee.setBirthdate(date);
		employee.setAddress(employeeEntityForm.getAddress());
		employee.setZip(employeeEntityForm.getZip());
		employee.setTelephone(employeeEntityForm.getTelephone());
		employee.setEmail(employeeEntityForm.getEmail());
		employee.setCountry(employeeEntityForm.getCountry());
		employeeManager.addEmployee(employee);
		return "registered";
	}
    
	// Show message to user telling he/she has been registered
	
	@RequestMapping(value = "/registered", method = RequestMethod.GET)
	public String registered(ModelMap model) {

		return "registered";
	}	
}
