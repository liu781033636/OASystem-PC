package com.persons.dao.impl;


import org.springframework.stereotype.Component;

import com.common.dao.BaseDaoImpl;
import com.persons.dao.EmployeeDao;
import com.persons.model.Employee;
@Component
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{

}
