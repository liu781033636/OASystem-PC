package com.persons.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.persons.model.Jobs;
import com.persons.service.JobsService;

@Service      //注入到spring的IOC
@Transactional    

public class JobsServiceImpl extends BaseServiceImpl<Jobs> implements JobsService{

}
