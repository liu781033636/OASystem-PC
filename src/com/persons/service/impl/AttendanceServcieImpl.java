package com.persons.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.persons.dao.AttendanceDao;
import com.persons.dao.EmployeeDao;
import com.persons.model.Attendance;
import com.persons.model.Employee;
import com.persons.service.AttendanceService;
import com.security.dao.UserDao;
@Service
//注入到spring的IOC
@Transactional
public class AttendanceServcieImpl extends BaseServiceImpl<Attendance> implements AttendanceService {
	AttendanceDao attendanceDao;
	EmployeeDao employeeDao;
	UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	@Resource
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public AttendanceDao getAttendanceDao() {
		return attendanceDao;
	}

	@Resource
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	/**
	 * 签到
	 */
	public Attendance  signIn(Integer empId){
		Date date=new Date();
		List<Employee> employee = employeeDao.findByHql("from Employee o where o.empId="+empId);
		//List<Attendance> attendanceList = attendanceDao.findByHql("from attendance a where a.empId="+empId);
		Attendance attendance=new Attendance();
		attendance.setEmployee(employee.get(0));
//		attendance.setEmpId(empId);
		attendance.setInTime(date);
		attendanceDao.save(attendance);		
		return attendance;

	}
	/**
	 * 签退
	 */
	public Attendance  signOut(Integer empId){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(date);
		List<Attendance> attendanceList = attendanceDao.findByHql("from Attendance  where emp_id="+empId);
		for(Attendance atd:attendanceList){
			if(isSameDay(atd.getInTime(),date)){	
				System.out.println(date);
				atd.setOutTime(date);
				return atd;			
			}				
		}
		return null;
	}
	
	/**
	 * 进人签到页面
	 */
	public Attendance sign(Integer empId){
		Date date=new Date();
		//DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		List<User> user= userDao.findByHql("from User u where u.id= "+currentUser.getId());
//		Integer empId=user.get(0).getEmployee().getEmpId();
		//List<Employee> employee = employeeDao.findByHql("from Employee o where o.empId="+empId);
		List<Attendance> attendanceList = attendanceDao.findByHql("from Attendance  where emp_id="+empId);
		for(Attendance atd:attendanceList){
			if(isSameDay(atd.getInTime(),date)){
				//System.out.println("test...."+atd.getInTime());
				return atd;
			}				
		}
		return null;
	}
	/**
	 * 判断日期是否是同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public boolean isSameDay(Date date1,Date date2){
		Calendar c1=Calendar.getInstance();
		c1.setTime(date1);
		
		Calendar c2=Calendar.getInstance();
		c2.setTime(date2);
		
		if(c1.get(Calendar.YEAR)==c2.get(Calendar.YEAR)
				&&c1.get(Calendar.MONTH)==c2.get(Calendar.MONTH)
				&&c1.get(Calendar.DAY_OF_MONTH)==c2.get(Calendar.DAY_OF_MONTH))
		return true;
		else 
			return false;
	}
}
