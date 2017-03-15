package com.persons.service;

import java.util.Date;

import org.slf4j.Logger;

import com.common.service.BaseService;
import com.persons.model.Attendance;

public interface AttendanceService extends BaseService<Attendance> {

	public Attendance sign(Integer empId);
	public Attendance signIn(Integer empId);
	public Attendance signOut(Integer empId);
}
