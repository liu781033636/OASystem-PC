package com.persons.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.common.bean.PagerModel;
import com.persons.model.Jobs;
import com.persons.service.EmployeeService;
import com.persons.service.JobsService;
import com.security.model.User;





/**
 * @author Huang_Hai
 *
 */
@Controller
@Scope("prototype")
public class JobsAction {
	
	
	private Logger logger=LoggerFactory.getLogger(JobsService.class);
	private JobsService jobsService;
	private Jobs jobs=new Jobs();
	private Integer jobsId;
    private PagerModel pm;
    private EmployeeService employeeService;
    
    
    
    

    public EmployeeService getEmployeeService() {
		return employeeService;
	}
    @Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public JobsService getJobsService() {
		return jobsService;
	}
    @Resource
	public void setJobsService(JobsService jobsService) {
		this.jobsService = jobsService;
	}
	public Integer getJobsId() {
		return jobsId;
	}
	public void setJobsId(Integer jobsId) {
		this.jobsId = jobsId;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	public PagerModel getPm() {
		return pm;
	}
	public void setPm(PagerModel pm) {
		this.pm = pm;
	}
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list()  {
		
		pm=jobsService.getPagerDesc(Jobs.class);
		return "list";
	}
	/**
	 * 删除
	 * @return
	 */
	
	public String del()
	{
		int size=employeeService.findByHql("from Employee where jobs_id="+jobsId).size();
		if(size==0){
		
		jobsService.deleteById(Jobs.class,jobsId);
		
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" del id="+jobs.getId());//日志记录
	
		return "pub_del_success";
		}
		else return "jobs_del_false";
	}
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
	//后台验证职位名称不能为空
		if(null!=jobs.getJobsName() && !"".equals(jobs.getJobsName()))
		{
		jobsService.saveAndRefresh(jobs);
		
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" add id="+jobs.getId());//日志记录
		}
		return "pub_add_success";
	}
	public String addInput()
	{
		return "add_input";
	}
	
	public String editInput()
	{  
	
	  jobs=jobsService.findById(Jobs.class,jobsId);
	  return "edit_input";
	}

	
	

	/**************************以上为各种input页面******************************************/
	
	/**
	 * 编辑
	 * @return
	 */
	public String update()
	{
		
		jobsService.update(jobs);
		
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" update id="+jobs.getId());//日志记录
		
		return "pub_add_success";
	}
	
	
	
}
