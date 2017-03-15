package com.persons.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.persons.model.Approval;
import com.persons.service.ApprovalService;

@Service
//注入到spring的IOC
@Transactional
public class ApprovalServiceImpl extends BaseServiceImpl<Approval> implements ApprovalService {

}
