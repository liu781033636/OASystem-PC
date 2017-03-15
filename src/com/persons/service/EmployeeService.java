package com.persons.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;

import com.common.service.BaseService;
import com.persons.model.Employee;

public interface EmployeeService extends BaseService<Employee> {
	public List<Employee>  getAllRdpts(); 
	public List<Employee> getWorkshopWorkers();
	public String add(Logger logger,Integer jobsId,List<Date> stDates,List<String> traNames,Employee employee,Integer departmentId, File uploadFile,String uploadFileFileName,String uploadFileContentType );
	public String edite(Logger logger,Integer jobsId,List<Date> stDates,List<String> traNames,Employee employee,Integer departmentId, File uploadFile,String uploadFileFileName,String uploadFileContentType );
}
