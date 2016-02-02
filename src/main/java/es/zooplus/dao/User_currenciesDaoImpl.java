package es.zooplus.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.zooplus.entity.EmployeeEntity;
import es.zooplus.entity.User_currenciesEntity;

@Repository
public class User_currenciesDaoImpl implements User_currenciesDAO  {
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addUser_currencies(User_currenciesEntity user_currencies) {
		this.sessionFactory.getCurrentSession().save(user_currencies);
	}

	@SuppressWarnings("unchecked")

	public List<User_currenciesEntity> getAllUser_currencies(Integer id_user) {
		return this.sessionFactory.getCurrentSession().createQuery("from User_currencies where id_user = :id_user order by time_created desc").setParameter("id_user", id_user).setMaxResults(10).list();
	}


	public void deleteUser_currencies(Integer user_currenciesId) {
		User_currenciesEntity user_currencies = (User_currenciesEntity) sessionFactory.getCurrentSession().load(
				User_currenciesEntity.class, user_currenciesId);
        if (null != user_currencies) {
        	this.sessionFactory.getCurrentSession().delete(user_currencies);
        }
	}	
}
