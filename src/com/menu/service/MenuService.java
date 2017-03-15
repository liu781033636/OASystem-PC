package com.menu.service;

import com.common.service.BaseService;

import com.security.model.User;
import com.menu.model.Menu;

public interface MenuService extends BaseService<Menu>{
	
	public  String writeNavs(User user);
	
	public  String writeMenuItems(Integer menuId, User user);
	
	public  String writeMenus(Integer navId,User user);
}
