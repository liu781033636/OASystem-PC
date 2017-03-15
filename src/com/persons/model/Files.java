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

import com.security.model.User;

@Entity
@Table(name="file")
public class Files implements Serializable{

	/**
	 * 文件ID
	 */
	private Integer id;
	
	/**
	 * 上传者
	 */
	private User sper;
	

	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 部门ID
	 */
	private Department department;
	
	/**
	 * 备注
	 */
	private String content;
	

	/**
	 * 上传时间
	 */
	private Date rastime;
	
	/**
	 * 文件
	 */
	private String accessories;
	
	/**
	 * 文件类型
	 */
	private String fileType;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Id
	@GeneratedValue
	@JoinColumn(name="fileid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)
	@JoinColumn(name="sper",nullable=false)
	public User getSper() {
		return sper;
	}

	public void setSper(User sper) {
		this.sper = sper;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)//persist更新  merge新建
	@JoinColumn(name="dpt_id",nullable=true)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRastime() {
		return rastime;
	}

	public void setRastime(Date rastime) {
		this.rastime = rastime;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}
	


}
