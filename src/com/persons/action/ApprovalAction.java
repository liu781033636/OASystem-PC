package com.persons.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.common.bean.PagerModel;
import com.persons.model.Approval;
import com.persons.model.Department;
import com.persons.service.ApprovalService;
import com.persons.service.EmployeeService;
import com.persons.service.JobsService;
import com.security.model.User;
import com.security.service.UserService;

@Controller
@Scope("prototype")
public class ApprovalAction {
	private Approval approval;
	private ApprovalService approvalService;
	private JobsService jobsService;
	private EmployeeService employeeService;
	private User rperString;//当前用户
	private PagerModel pm;
	private Integer approvalId;
	private Integer userId;
	private UserService userService;
	
	

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(Integer approvalId) {
		this.approvalId = approvalId;
	}
	public PagerModel getPm() {
		return pm;
	}
	public void setPm(PagerModel pm) {
		this.pm = pm;
	}
	public User getRperString() {
		return rperString;
	}
	public void setRperString(User rperString) {
		this.rperString = rperString;
	}
	public Approval getApproval() {
		return approval;
	}
	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	public ApprovalService getApprovalService() {
		return approvalService;
	}
	@Resource
	public void setApprovalService(ApprovalService approvalService) {
		this.approvalService = approvalService;
	}
	public JobsService getJobsService() {
		return jobsService;
	}
	@Resource
	public void setJobsService(JobsService jobsService) {
		this.jobsService = jobsService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * 获取当前用户
	 * @return
	 */
	private User users(){
		rperString=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return rperString;
	}
	
	/**
	 * 审批列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() {
		Integer level=this.users().getEmployee().getJobs().getLevel();
		String  status=null;
		if(level==1)
			status="0";
		else if(level==2)
			status="1";
		else status="-1";
		pm=approvalService.getPagerDesc(Approval.class, 
				"where  o.status =" +status
				+"and o.sper.employee.department ="+this.users().getEmployee().getDepartment().getId());
		//pm= attendanceService.getPagerDesc(Attendance.class);
		//pm = employeeService.getEmPager(PagerInfo.getOffset(), PagerInfo.getPagesize());
		//departmentList = departmentService.findByHql("from Department ");

		return "list";
	}
	
	/**
	 * 我的申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String myList() {
		pm=approvalService.getPagerDesc(Approval.class, "where o.sper= "+this.users().getId());
		
		return "myList";
	}
	
	/**
	 * 审批详情
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() {
		approval =approvalService.findById(Approval.class, approvalId);
		return "show";
	}
	
	/**
	 * 模糊查询我的审批（标题）
	 * @return
	 */
	public String mySearch()
	{
		Map<String,String> like=new HashMap<String,String>();
		
			//like.put("sper.employee.empName", approval.getSper().getEmployee().getEmpName());
			like.put("title",  approval.getTitle());
			like.put("sper", this.users().getId().toString());
		pm=approvalService.fuzzyQuery(Approval.class,like);
		return "myList";
		
	}
	
	/**
	 * 模糊查询审批（标题,员工）
	 * @return
	 */
	public String search()
	{
		Integer level=this.users().getEmployee().getJobs().getLevel();
		String  status=null;
		if(level==1)
			status="0";
		else if(level==2)
			status="1";
		else status="-1";
		
		Map<String,String> like=new HashMap<String,String>();
		
			like.put("sper.employee.empName", approval.getSper().getEmployee().getEmpName());
			like.put("title",  approval.getTitle());
			like.put("sper not", this.users().getId().toString());
			like.put("status", status);
			like.put("sper.employee.department.id", this.users().getEmployee().getDepartment().getId().toString());
		pm=approvalService.fuzzyQuery(Approval.class,like);
		return "list";
		
	}
	
	public String addInput(){
		return "addInput";
	}
	
	public String add(){
		approval.setSper(this.users());
		approval.setTime(new Date());
		approval.setStatus("0");
		approvalService.saveAndRefresh(approval);
		return "pub_add_success";
	}
	
	public String del(){
		approvalService.deleteById(Approval.class, approvalId);
		return "pub_del_success";
	}
	
	public String appr(){
		//System.out.println(approvalId);
		
//		Approval appr =approvalService.findById(Approval.class, approvalId);
//		approval.setSper(appr.getSper());
//		approval.setTitle(appr.getTitle());
//		approval.setTime(appr.getTime());
//		approval.setRper(this.users());
//		approval.setId(appr.getId());
		approval.setRper(this.users());

		approval.setSper(userService.findById(User.class, userId));
		System.out.println(approval.getSper().getEmployee().getEmpName()+approval.getStatus());

		approvalService.update(approval);
		return "pub_update_success";
		
	}
}
