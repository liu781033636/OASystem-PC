package com.menu.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.service.BaseServiceImpl;
import com.menu.model.MenuItem;
import com.menu.service.MenuItemService;

@Service
@Transactional
public class MenuItemServiceImpl extends BaseServiceImpl<MenuItem> implements MenuItemService{
	

}
