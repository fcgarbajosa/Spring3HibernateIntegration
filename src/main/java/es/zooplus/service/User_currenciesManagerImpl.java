package es.zooplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.zooplus.dao.EmployeeDAO;
import es.zooplus.dao.User_currenciesDAO;
import es.zooplus.entity.EmployeeEntity;
import es.zooplus.entity.User_currenciesEntity;

public class User_currenciesManagerImpl implements User_currenciesManager {

	@Autowired
    private User_currenciesDAO user_currenciesDAO;
	
	@Transactional
	public void addUser_currencies(User_currenciesEntity user_currencies) {
		user_currenciesDAO.addUser_currencies(user_currencies);
	}
    
	@Transactional
	public List<User_currenciesEntity> getAllUser_currencies(Integer id_user) {
		
		return user_currenciesDAO.getAllUser_currencies(id_user);
	}
	
	@Transactional
	public void deleteUser_currencies(Integer user_currencyId) {
		
		user_currenciesDAO.deleteUser_currencies(user_currencyId);
	}
	
	public void setUser_currenciesDAO(User_currenciesDAO user_currenciesDAO) {
		this.user_currenciesDAO = user_currenciesDAO;
	}	
}
