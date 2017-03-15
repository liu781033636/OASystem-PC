package com.persons.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.common.dao.BaseDaoImpl;
import com.persons.dao.DepartmentDao;
import com.persons.model.Department;
@Component
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{
	public List<Department> getAllDepartments() {
		return super.getHibernatetemplate().find("from Department");
	}

//	public List<Department> getWorkshops() {
//		return super.getHibernatetemplate().find("from Department d where d.dptType = 2");
//	}
	
	public Department getByDptName(String dptName)
	{
		List<Department> departments = getHibernatetemplate().find("from Department d where d.dptName = '"+dptName+"'");
		if(null==departments||departments.size()==0)
		{
			return null;
		}
		return departments.get(0);
	}
}


