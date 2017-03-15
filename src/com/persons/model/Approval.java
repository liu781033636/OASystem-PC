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
@Table(name="approval")
public class Approval implements Serializable{

	/**
	 * ID
	 */
	private Integer id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;

	/**
	 * 申请人
	 */
	private User sper;
	
	/**
	 * 审批人
	 */
	private User rper;
	
	
	/**
	 * 申请时间
	 */
	private Date time;
	
	/**
	 *状态
	 */
	private String status;
	
	/**
	 *备注
	 */
	private String content2;

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	@Id
	@GeneratedValue
	@JoinColumn(name="approvalid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)
	@JoinColumn(name="sper",nullable=false)
	public User getSper() {
		return sper;
	}

	public void setSper(User sper) {
		this.sper = sper;
	}
	
	@ManyToOne(cascade=CascadeType.PERSIST.MERGE)
	@JoinColumn(name="rper",nullable=true)
	public User getRper() {
		return rper;
	}

	public void setRper(User rper) {
		this.rper = rper;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}  
	
	
}
