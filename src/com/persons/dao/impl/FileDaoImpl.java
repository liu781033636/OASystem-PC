package com.persons.dao.impl;

import org.springframework.stereotype.Component;

import com.common.dao.BaseDaoImpl;
import com.persons.dao.FileDao;
import com.persons.model.Files;

@Component
public class FileDaoImpl  extends BaseDaoImpl<Files> implements FileDao{

}
