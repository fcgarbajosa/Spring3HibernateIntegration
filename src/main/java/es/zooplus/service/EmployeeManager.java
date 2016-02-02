package es.zooplus.service;

import java.util.List;

import es.zooplus.entity.EmployeeEntity;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public Integer findEmployee(String username);    
}
