package com.persons.action;

import java.io.File;
import java.text.SimpleDateFormat;
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
import com.persons.model.Department;
import com.persons.model.Employee;
import com.persons.model.Jobs;
import com.persons.service.DepartmentService;
import com.persons.service.EmployeeService;
import com.persons.service.JobsService;
import com.security.model.User;


@Controller
@Scope("prototype")
public class EmployeeAction {
	private Logger logger = LoggerFactory.getLogger(EmployeeAction.class);
	private EmployeeService employeeService;
	private Employee employee = new Employee();
	private Integer employeeId;
	private Integer employeeRapId;
	private Integer departmentId;
	private Integer jobsId;
	private String paname;
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;
	private PagerModel pm;
	private List<String> traNames;
	private List<Date> stDates;

	/**
	 * 用于页面显示的临时生日字符串
	 */
	String birString;
	/**
	 * 用于页面显示的临时进入公司时间字符串
	 */
	String eDateString;
	/**
	 * 用于页面显示的临时离开公司时间字符串
	 */
	String lDateString;


	private List<Department> departmentList;// =new ArrayList<Department>();
	private List<Employee> employeeList;
	private DepartmentService departmentService;
	private List<Jobs> jobsList;
	private JobsService jobsService;

	
	public String getPaname() {
		return paname;
	}

	public void setPaname(String paname) {
		this.paname = paname;
	}

	public List<Jobs> getJobsList() {
		return jobsList;
	}

	public void setJobsList(List<Jobs> jobsList) {
		this.jobsList = jobsList;
	}

	public JobsService getJobsService() {
		return jobsService;
	}

	@Resource
	public void setJobsService(JobsService jobsService) {
		this.jobsService = jobsService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmployeeRapId() {
		return employeeRapId;
	}

	public void setEmployeeRapId(Integer employeeRapId) {
		this.employeeRapId = employeeRapId;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PagerModel getPm() {
		return pm;
	}

	public void setPm(PagerModel pm) {
		this.pm = pm;
	}

	public String getBirString() {
		return birString;
	}

	public void setBirString(String birString) {
		this.birString = birString;
	}

	public String geteDateString() {
		return eDateString;
	}

	public void seteDateString(String eDateString) {
		this.eDateString = eDateString;
	}

	public String getlDateString() {
		return lDateString;
	}

	public void setlDateString(String lDateString) {
		this.lDateString = lDateString;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getJobsId() {
		return jobsId;
	}

	public void setJobsId(Integer jobsId) {
		this.jobsId = jobsId;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}


	public List<String> getTraNames() {
		return traNames;
	}

	public void setTraNames(List<String> traNames) {
		this.traNames = traNames;
	}

	public List<Date> getStDates() {
		return stDates;
	}

	public void setStDates(List<Date> stDates) {
		this.stDates = stDates;
	}
	

	/**
	 * 列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() {
		pm= employeeService.getPagerDesc(Employee.class,"where o.isdel is null or o.isdel = 0");
		//pm = employeeService.getEmPager(PagerInfo.getOffset(), PagerInfo.getPagesize());
		departmentList = departmentService.findByHql("from Department ");
		jobsList = jobsService.findByHql("from Jobs");
		return "list";
	}

	/**
	 * 模糊查询（对姓名、性别、职位）
	 * 
	 * @return
	 */
	public String search() {
		Map<String, String> like = new HashMap<String, String>();
        if(employee!=null){
        	if(employee.getEmpName()!=null&employee.getSex()!=null&employee.getDepartment()!=null&employee.getJobs()!=null){
        		like.put("empName", employee.getEmpName());//员工名称
        		like.put("sex", employee.getSex());//员工性别
        		like.put("department.dptName", employee.getDepartment().getDptName());//员工部门
        		like.put("jobs.jobsName", employee.getJobs().getJobsName());//员工职位
        		pm = employeeService.fuzzyQuery(Employee.class, like);
        	}
	        else{
	        	pm = employeeService.getPagerDesc(Employee.class);
	        }
			
        }else{
        	pm = employeeService.getPagerDesc(Employee.class);
        }
		departmentList = departmentService.findByHql("from Department   ");
		jobsList = jobsService.findByHql("from Jobs");

		return "list";
	}

	public String show() {
		employee = employeeService.findById(Employee.class, employeeId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		if (employee.getBirdate() != null) {
			birString = sdf.format(employee.getBirdate());
		}

		if (employee.geteDate() != null) {
			eDateString = sdf.format(employee.geteDate());
		}

		if (employee.getlDate() != null) {
			lDateString = sdf.format(employee.getlDate());
		}
		return "show";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */

	public String del() {
		Employee employee=employeeService.load(Employee.class, employeeId);
		employee.setIsdel(1);
		employeeService.update(employee);
		
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" del id="+employee.getEmpId());//日志记录
		
		return "pub_del_success";
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		
		return employeeService.add(logger, jobsId, stDates, traNames, employee, departmentId, uploadFile, uploadFileFileName, uploadFileContentType);
	}

	/*
	 * ===================================input==================================
	 * ==========================
	 */

	public String addInput() {
		departmentList = departmentService.findByHql("from Department   ");
		jobsList = jobsService.findByHql("from Jobs");
		return "add_input";
	}

	public String editInput() {

		employee = employeeService.findById(Employee.class, employeeId);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		if (employee.getBirdate() != null) {
			birString = sdf1.format(employee.getBirdate());
		}

		if (employee.geteDate() != null) {
			eDateString = sdf1.format(employee.geteDate());
		}

		if (employee.getlDate() != null) {
			lDateString = sdf1.format(employee.getlDate());
		}

		departmentList = departmentService.findByHql("from Department   ");
		if (departmentId == null) {
			try {
				departmentId = employee.getDepartment().getId();

			} catch (Exception e) {
				// TODO: handle exception
			}
			jobsList = jobsService.findByHql("from Jobs");
			if (jobsId == null) {
				try {
					jobsId = employee.getJobs().getId();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
		
		return "edit_input";
	}

	/************************** 以上为各种input页面 ******************************************/

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String update() {
		return employeeService.edite( logger, jobsId, stDates, traNames, employee, departmentId, uploadFile, uploadFileFileName, uploadFileContentType);
	}



	
	/**
	 * 用来选择员工
	 */
	public String selectInput() {
		
		departmentList = departmentService.findByHql("from Department      ");
		jobsList = jobsService.findByHql("from Jobs");
		pm = employeeService.getPagerDesc(Employee.class,"where o.isdel is null or o.isdel =0");
		return "searchSelect";

	}

	/**
	 * 选择员工的时候查询用的
	 */
	public String searchSelect() {
		Map<String, String> like = new HashMap<String, String>();

		like.put("empName", employee.getEmpName());
		like.put("sex", employee.getSex());
		like.put("department.dptName", employee.getDepartment().getDptName());
		like.put("jobs.jobsName", employee.getJobs().getJobsName());

		pm = employeeService.fuzzyQuery(Employee.class, like);
		departmentList = departmentService.findByHql("from Department   ");
		jobsList = jobsService.findByHql("from Jobs");

		return "searchSelect";
	}
}
