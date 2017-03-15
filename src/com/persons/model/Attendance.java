package com.persons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 考勤表
 * @author 
 *
 */
@Entity
@Table(name="attendance")
public class Attendance implements Serializable{

	/**
	 * ID
	 */
	private Integer id;
		
	/**
	 * 签到时间
	 */
	private Date inTime;
	/**
	 * 签退时间
	 */
	private Date outTime;
	
	private Employee employee;
//	private Integer empId;
//	
//	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)
//	@JoinColumn(name="emp_id",nullable=true)	
//	public Integer getEmpId() {
//		return empId;
//	}
//	public void setEmpId(Integer empId) {
//		this.empId = empId;
//	}
	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)
	@JoinColumn(name="emp_id",nullable=true)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Id
	@GeneratedValue
	@JoinColumn(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@JoinColumn(name="intime")
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@JoinColumn(name="outtime")
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
}
