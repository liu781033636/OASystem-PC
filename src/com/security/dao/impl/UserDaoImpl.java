package com.security.dao.impl;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.common.dao.BaseDaoImpl;
import com.security.dao.UserDao;
import com.security.model.User;
@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public static ServletContext context;
	public Object update(Object entity){
		// TODO Auto-generated method stub
		//this.getHibernatetemplate().getSessionFactory().getCurrentSession().clear();
		this.getHibernatetemplate().merge(entity);
	
		
		
		return entity;
	}

	
}
