package com.security.service;

import java.util.List;
import java.util.Set;

import com.common.service.BaseService;
import com.menu.model.Menu;
import com.menu.model.MenuItem;
import com.menu.model.Nav;
import com.security.model.Resource;

public interface ResourceService extends BaseService<Resource>{

	public Set<Resource> getResourceSetByIds(List<Integer> ids);
	public List<Nav> getNavs();
	public List<Menu> findMenu(String menuNavId);
	public List<MenuItem> findItemMenu(String itemmenumenuid);
	public List<Menu> getMenus();
	public List<MenuItem> getItemMenus();
	public List<Resource> getTestResouce(); 
	public MenuItem getById(Integer id);
	public List<Menu> findMenusByResource(Integer id);
	public List<MenuItem> findItemMenuByResource(Integer id); 
}
