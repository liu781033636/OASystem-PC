package com.persons.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.common.bean.PagerModel;
import com.persons.model.Attendance;
import com.persons.model.Department;
import com.persons.model.Employee;
import com.persons.service.AttendanceService;
import com.persons.service.DepartmentService;
import com.persons.service.EmployeeService;
import com.security.model.User;

@Controller
@Scope("prototype")
public class AttendanceAction {
	private Logger logger = LoggerFactory.getLogger(AttendanceAction.class);
	private AttendanceService attendanceService;
	private Attendance attendance;
	private EmployeeService employeeService;
	private List<Department> departmentList;
	private DepartmentService departmentService;
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public PagerModel getPm() {
		return pm;
	}

	public void setPm(PagerModel pm) {
		this.pm = pm;
	}

	private PagerModel pm;
	//List<Attendance>
	
	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public AttendanceService getAttendanceService() {
		return attendanceService;
	}
	@Resource
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	

	/**
	 * 签到签退页面
	 * @return
	 * @throws Exception	
	 */
	public String sign()  {
	User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	Employee employee=currentUser.getEmployee();
	if(employee!= null){
		attendance=attendanceService.sign(employee.getEmpId());
		if(attendance==null){
			attendance =new Attendance();
			attendance.setEmployee(employee);
			attendance.setInTime(new Date());
			attendanceService.saveAndRefresh(attendance);
		}
		return "sign";
	}
	else return "false";
//	System.out.println("test.."+attendance.getInTime());
		
	}
	
	/**
	 * 签到
	 * @return
	 */
	public String signIn(){
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer empId=currentUser.getEmployee().getEmpId();
		attendance=attendanceService.signIn(empId);
		return "sign";
	}
	
	/**
	 * 签退
	 * @return
	 */
	public String signOut(){
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Integer empId=currentUser.getEmployee().getEmpId();
		attendance=attendanceService.signOut(empId);
		return "sign";
	}
	
	/**
	 * 考勤列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() {
		pm= attendanceService.getPagerDesc(Attendance.class);
		//pm = employeeService.getEmPager(PagerInfo.getOffset(), PagerInfo.getPagesize());
		departmentList = departmentService.findByHql("from Department ");

		return "list";
	}
	
	/**
	 * 模糊查询（对姓名、工号）
	 * @return
	 */

	public String search() {
		Map<String, String> like = new HashMap<String, String>();
        if(attendance!=null){
        	if(attendance.getEmployee().getEmpName()!=null){//&attendance.getEmployee().getEmpId()!=null){
        		like.put("employee.empName", attendance.getEmployee().getEmpName());
        		like.put("employee.department.dptName", attendance.getEmployee().getDepartment().getDptName());
        		//like.put("empolyee.empId", attendance.getEmployee().getEmpId().toString());
        		System.out.println("test......."+attendance.getEmployee().getEmpName()+attendance.getEmployee().getDepartment().getDptName());
        		pm = attendanceService.fuzzyQuery(Attendance.class, like);
        	}
	        else{
	        	pm = attendanceService.getPagerDesc(Attendance.class);
	        }
			
        }else{
        	pm = attendanceService.getPagerDesc(Attendance.class);
        }
        
		departmentList = departmentService.findByHql("from Department");

		return "list";

	}
}
