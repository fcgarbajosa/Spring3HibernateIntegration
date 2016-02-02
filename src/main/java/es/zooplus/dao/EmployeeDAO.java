package es.zooplus.dao;

import java.util.List;

import es.zooplus.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public Integer findEmployee(String username);

}