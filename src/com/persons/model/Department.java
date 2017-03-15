package com.persons.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 部门信息表
 * @author 
 *
 */
@Entity
@Table(name="department")
public class Department implements Serializable{
	
	private Set<Employee> employees = new HashSet<Employee>();
    
	@OneToMany(mappedBy="department",cascade={CascadeType.ALL})
	   public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	

	/**
	 * 部门ID
	 */
	private Integer id;
	
	/**
	 * 部门名称
	 */
	private String dptName;
	
	

	/**
	 * 部门描述
	 */
	private String dptDes;
	

	
	@JoinColumn(name="dpt_id")
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JoinColumn(name="dpt_name")
	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	@JoinColumn(name="dpt_des")
	public String getDptDes() {
		return dptDes;
	}

	public void setDptDes(String dptDes) {
		this.dptDes = dptDes;
	}



	
}
