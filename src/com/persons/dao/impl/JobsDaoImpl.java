package com.persons.dao.impl;

import org.springframework.stereotype.Component;

import com.common.dao.BaseDaoImpl;
import com.persons.dao.JobsDao;
import com.persons.model.Jobs;

@Component
public class JobsDaoImpl extends BaseDaoImpl<Jobs> implements JobsDao{

}
