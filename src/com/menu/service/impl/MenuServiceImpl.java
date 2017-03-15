package com.menu.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.common.service.BaseServiceImpl;
import com.menu.dao.MenuItemDao;
import com.menu.dao.NavDao;
import com.menu.model.Menu;
import com.menu.model.Nav;
import com.menu.service.MenuService;
import com.security.dao.ResourceDao;
import com.security.model.Resource;
import com.security.model.User;

@org.springframework.stereotype.Service("menuServiceImpl")
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService{
	private NavDao navDao;
	private MenuItemDao menuItemDao;
	private ResourceDao resourceDao;

	
	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	@javax.annotation.Resource
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	@javax.annotation.Resource
	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	public NavDao getNavDao() {
		return navDao;
	}

	@javax.annotation.Resource
	public void setNavDao(NavDao navDao) {
		this.navDao = navDao;
	}

	public String writeNavs(User user)
	{
		String result="";
		String rt="\r\n";//回车换行
		Set<Integer> ids = new HashSet<Integer>();
		Map<String, List<com.security.model.Resource>> roleResources = user.getRoleResources();
		Collection<List<com.security.model.Resource>> values = roleResources.values();
		for (Iterator iterator = values.iterator(); iterator.hasNext();) {
			List<Resource> list = (List<Resource>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Resource resource = (Resource) iterator2.next();
				if(resource.getMenuItem()!=null)
				{
					ids.add(resource
					.getMenuItem()
					.getMenu()
					.getNav()
					.getId());
				}
			}
		}
		StringBuffer hqlString = new StringBuffer("from Nav nav where nav.id in (");
//		StringBuffer hqlString = new StringBuffer("from Nav nav ");

		for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
			Integer id = (Integer) iterator.next();
			hqlString.append(id+",");
		}
		hqlString.deleteCharAt(hqlString.length()-1);
		hqlString.append(")");
		//System.out.println("hql = "+hqlString);
		List<Nav> navs = navDao.findByHql(hqlString.toString());
		result+="<ul class='nav_content'>"+rt;
		for(int i=0;i<navs.size();i++)
		{
			Nav nav = navs.get(i);
			if(i==0)
			{
				result+="<li class='current'>"+rt;
			}
			else
			{
				result+="<li>"+rt;
			}
			result+="<a href='menu/menu?navId="+nav.getId()+"&index="+i+"' title='"+nav.getContent()+"' target=menu><font>"+nav.getContent()+"</font></a>"+rt;
			result+="</li>"+rt;
		}
		result+="</ul>"+rt;
		return result;
	}
	
	public String writeMenuItems(Integer menuId, User user)
	{
		Set<Integer> ids = new HashSet<Integer>();
		Map<String, List<com.security.model.Resource>> roleResources = user.getRoleResources();
		Collection<List<com.security.model.Resource>> values = roleResources.values();
		for (Iterator iterator = values.iterator(); iterator.hasNext();) {
			List<Resource> list = (List<Resource>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Resource resource = (Resource) iterator2.next();
				if(resource.getMenuItem()!=null)
				{
					ids.add(resource
					.getMenuItem()
					.getId());
				}
			}
		}
		StringBuffer hqlString = new StringBuffer("from Resource r where r.menuItem.menu.id = "+menuId+" and r.menuItem.id in (");
		for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
			Integer id = (Integer) iterator.next();
			hqlString.append(id+",");
		}
		hqlString.deleteCharAt(hqlString.length()-1);
		hqlString.append(")");
		String result="";
		String rt="\r\n";//回车换行
		List<Resource> resources = resourceDao.findByHql(hqlString.toString());
		for (Iterator iterator = resources.iterator(); iterator.hasNext();) {
			Resource resource = (Resource) iterator.next();
			result+="<li>"+rt+
            "<a href='.."+resource.getValue().replace("**", "")+"' target=main>"+resource.getMenuItem().getContent()+"</a>"+rt+
          "</li>"+rt;
		}
		return result;
	}
	
	public String writeMenus(Integer navId,User user)
	{
		Menu menu = null;
		Set<Integer> ids = new HashSet<Integer>();
		Map<String, List<com.security.model.Resource>> roleResources = user.getRoleResources();//获取角色对应的资源权限
		Collection<List<com.security.model.Resource>> values = roleResources.values();//获取资源地址
		for (Iterator iterator = values.iterator(); iterator.hasNext();) {//遍历获取的资源地址
			List<Resource> list = (List<Resource>) iterator.next();
			for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
				Resource resource = (Resource) iterator2.next();
				if(resource.getMenuItem()!=null)
				{
					ids.add(resource
					.getMenuItem()
					.getMenu()
					.getId());//获取一级菜单唯一标识
				}
			}
		}
		StringBuffer hqlString = new StringBuffer("from Menu menu where menu.nav.id = "+navId+" and menu.id in (");//搜索二级菜单
		for (Iterator iterator = ids.iterator(); iterator.hasNext();) {
			Integer id = (Integer) iterator.next();
			hqlString.append(id+",");
		}
		hqlString.deleteCharAt(hqlString.length()-1);
		hqlString.append(")");
		String result="";
		String rt="\r\n";//回车换行
		result+="<ul  id='nav'>"+rt;
		List<Menu> menus = findByHql(hqlString.toString());
		for(int i=0;i<menus.size();i++)//遍历二级菜单
		{
			menu = menus.get(i);
			result+="<li class='menu'>"+rt;
			result+="<ul>"+rt+
            "<li class='button'>"+rt+
              "<a href='#' class='blue'>" +
              menu.getContent()+"</a>"+
            "</li>"+rt+
            "<li class='dropdown'>"+rt+
            "<ul>"+rt;
			result+=writeMenuItems(menu.getId(),user);//写三级菜单
			result+="</ul>"+rt+
			"</li>"+rt+
			"</ul>"+rt+
            "</li>"+rt;
		}
		result+="</ul>";
		return result;//生成html格式的菜单
	}


}
