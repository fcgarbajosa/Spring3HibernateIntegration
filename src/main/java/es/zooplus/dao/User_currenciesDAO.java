package es.zooplus.dao;

import java.util.List;

import es.zooplus.entity.User_currenciesEntity;

public interface User_currenciesDAO {
    public void addUser_currencies(User_currenciesEntity user_currencies);
    public List<User_currenciesEntity> getAllUser_currencies(Integer id_user);
    public void deleteUser_currencies(Integer user_currencyId);
}
