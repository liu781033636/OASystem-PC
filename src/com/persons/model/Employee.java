package com.persons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 员工信息
 *
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable {
	

	/**
	 * 数据库ID
	 */
	private Integer empId;

	/**
	 * 员工号ID
	 */
	private String empSn;

	/**
	 * 职位ID
	 */
	private Jobs jobs;

	/**
	 * 部门ID
	 */
	private Department department;


	/**
	 *员工姓名
	 */
	private String empName;

	/**
	 *出生年月
	 */
	private Date birdate;

	/**
	 *性别
	 */
	private String sex;

	/**
	 *状态
	 */
	
	private String status;

	/**
	 *政治面貌
	 */
	private String political;

	/**
	 *宿舍号
	 */
	private String dormitory;

	/**
	 *文化程度
	 */
	private String education;

	/**
	 *员工性质
	 */
	private String nature;

	/**
	 *进入公司时间
	 */
	private Date eDate;

	/**
	 *离开公司时间
	 */
	private Date lDate;

	/**
	 * 头像
	 */
	private String pic;
	private Integer isdel;
	
	/**
	 * 考勤
	 */
	private Set<Attendance> attendances = new HashSet<Attendance>();

	@OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL })
	public Set<Attendance> getAttendances() {
		return attendances;
	}
	

	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}


	/**
	 *身份证号
	 */
	private String idCardNo;

	/**
	 *培训情况
	 */
	private String trStatus;

	/**
	 *默认菜单
	 */
	private String defaultMenu;

	/**
	 *婚姻状况
	 */
	private String marStatus;

	/**
	 *联系方式
	 */
	private String phoneNo;

	/**
	 *职称
	 */
	private String jobTitle;



	@JoinColumn(name="birdate")
	public Date getBirdate() {
		return birdate;
	}

	@JoinColumn(name="defaultmenu")
	public String getDefaultMenu() {
		return defaultMenu;
	}

	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)//persist更新  merge新建
	@JoinColumn(name="dpt_id",nullable=true)
	public Department getDepartment() {
		return department;
	}


	@JoinColumn(name="dormitory")
	public String getDormitory() {
		return dormitory;
	}

	@JoinColumn(name="edate")
	public Date geteDate() {
		return eDate;
	}

	@JoinColumn(name="education")
	public String getEducation() {
		return education;
	}

	@Id
	@GeneratedValue
	@JoinColumn(name="emp_id")
	public Integer getEmpId() {
		return empId;
	}


	@JoinColumn(name="emp_name")
	public String getEmpName() {
		return empName;
	}

	@JoinColumn(name="emp_sn")
	public String getEmpSn() {
		return empSn;
	}

	@JoinColumn(name="idcardno")
	public String getIdCardNo() {
		return idCardNo;
	}

	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)//persist更新  merge新建
	@JoinColumn(name="jobs_id",nullable=true)
	public Jobs getJobs() {
		return jobs;
	}

	@JoinColumn(name="jobtile")
	public String getJobTitle() {
		return jobTitle;
	}

	@JoinColumn(name="ldate")
	public Date getlDate() {
		return lDate;
	}

	@JoinColumn(name="marstatus")
	public String getMarStatus() {
		return marStatus;
	}

	@JoinColumn(name="nature")
	public String getNature() {
		return nature;
	}

	@JoinColumn(name="emp_phoneno")
	public String getPhoneNo() {
		return phoneNo;
	}

	public String getPic() {
		return pic;
	}

	@JoinColumn(name="political")
	public String getPolitical() {
		return political;
	}


	@JoinColumn(name="sex")
	public String getSex() {
		return sex;
	}
	


	@JoinColumn(name="status")
	public String getStatus() {
		return status;
	}


	
	@JoinColumn(name="trstatus")
	public String getTrStatus() {
		return trStatus;
	}
	
	

	public void setBirdate(Date birdate) {
		this.birdate = birdate;
	}

	public void setDefaultMenu(String defaultMenu) {
		this.defaultMenu = defaultMenu;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpSn(String empSn) {
		this.empSn = empSn;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}

	public void setMarStatus(String marStatus) {
		this.marStatus = marStatus;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}


	public void setPolitical(String political) {
		this.political = political;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	


	public void setTrStatus(String trStatus) {
		this.trStatus = trStatus;
	}
	
	
}
