package com.persons.service;



import java.util.List;

import org.slf4j.Logger;

import com.common.service.BaseService;
import com.persons.model.Department;

public interface DepartmentService extends BaseService<Department> {
	public List<Department> getAllDepartments();
	public List<Department> getAllFdpts();
//	public List<Department> getWorkshops();
	public Department getByDptName(String dptName);
	public String del(Logger logger,Integer departmentId);
}


