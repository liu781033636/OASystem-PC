package com.security.dao;

import com.common.dao.BaseDao;
import com.security.model.User;

/**
 * @author Chen_Luqiang
 *
 */
public interface UserDao extends BaseDao<User>{
	public Object update(Object entity);
}
