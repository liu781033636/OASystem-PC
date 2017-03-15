package com.security.service.impl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.security.dao.RoleDao;
import com.security.model.Resource;
import com.security.model.Role;
import com.security.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@javax.annotation.Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public void save(String name, String description, Set<Resource> resources) {
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);
		role.setResources(resources);
		this.save(role);
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public void deleteById(Serializable id) {
		roleDao.deleteById(Role.class, id);
	}

	public Set<Role> getRoleSetByIds(List<Integer> ids) {
		Set<Role> roles = new HashSet<Role>();
		if (null != ids) {
			for (Integer id : ids) {
				roles.add(this.findById(Role.class, id));
			}
		}
		return roles;
	}
}
