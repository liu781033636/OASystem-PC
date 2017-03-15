package com.security.dao;

import java.io.Serializable;

import com.common.dao.BaseDao;
import com.security.model.Role;

/**
 * @author Chen_Luqiang
 *
 */
public interface RoleDao  extends BaseDao<Role> {
	public Object update(Object entity);
	public <T> T deleteById(Class<T> entityclass ,Serializable id);
}
