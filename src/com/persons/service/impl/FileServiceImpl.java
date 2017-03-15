package com.persons.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.persons.model.Files;
import com.persons.service.FileService;

@Service
//注入到spring的IOC
@Transactional
public class FileServiceImpl extends BaseServiceImpl<Files> implements FileService{

}
