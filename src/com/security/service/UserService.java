package com.security.service;

import java.io.Serializable;
import java.util.Set;

import com.common.bean.PagerModel;
import com.common.service.BaseService;
import com.persons.model.Employee;
import com.security.model.Role;
import com.security.model.User;

public interface UserService  extends BaseService<User>{
	
	public void save(String name,String password,Employee employee,Set<Role> roles);
	public void update(User user);
	public void deleteById(Serializable id);
	public PagerModel getPagerDesc();
}
