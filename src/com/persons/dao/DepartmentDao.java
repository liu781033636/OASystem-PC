package com.persons.dao;

import java.util.List;

import com.common.dao.BaseDao;
import com.persons.model.Department;




public interface DepartmentDao extends BaseDao<Department>{
	public List<Department> getAllDepartments();
	//public List<Department> getWorkshops();
	public Department getByDptName(String dptName);
}
