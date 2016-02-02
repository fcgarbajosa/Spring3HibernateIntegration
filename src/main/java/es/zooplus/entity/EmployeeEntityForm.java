package es.zooplus.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeEntityForm {

	    private Integer id;
	    
	    private String username;

	    private String password;
	    
	    private String passwordconf;
	     
	    private String firstname;
	 
	    private String lastname;
	 
	    private String address;

	    private String birthdateday;
	    
	    private String birthdatemonth;

	    private String birthdateyear;
	    
	    private String city;

	    private String zip;
	    
	    private String telephone;
	     
	    private String email;
	 
	    private Integer country;

	    public Integer getId() {
	        return id;
	    }
	    
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    
	    public String getFirstname() {
	        return firstname;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getPasswordconf() {
	        return passwordconf;
	    }

	    public void setPasswordconf(String passwordconf) {
	        this.passwordconf = passwordconf;
	    }
	    
	    public String getBirthdateday() {
	        return birthdateday;
	    }

	    public void setBirthdateday(String birthdateday) {
	        this.birthdateday = birthdateday;
	    }

	    public String getBirthdatemonth() {
	        return birthdatemonth;
	    }

	    public void setBirthdatemonth(String birthdatemonth) {
	        this.birthdatemonth = birthdatemonth;
	    }
	    
	    public String getBirthdateyear() {
	        return birthdateyear;
	    }

	    public void setBirthdateyear(String birthdateyear) {
	        this.birthdateyear = birthdateyear;
	    }    

	    
	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }    
	    
	    public String getZip(){
	    	 return zip;
	    }

	    public void setZip(String zip) {
	        this.zip = zip;
	    }
	    
	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Integer getCountry() {
	        return country;
	    }
	    
	    public void setCountry(Integer country) {
	        this.country = country;
	    }

}
