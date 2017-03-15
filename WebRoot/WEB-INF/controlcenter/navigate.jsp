<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
    

 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>head1</title>
    
    <base href="<%=basePath%>"/>
    <style type="text/css">
<!--	
/*通用*/
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}

.menu_nav{margin:20px 0 0 43px;height:80px;background:#008080;width:1100px;}
.menu_nav a{display:block;float:left;padding:9px 0px 9px;cursor:pointer;}
.menu_nav a font{display:block;width:117px;height:22px;border-left:1px #009999 solid;border-right:1px #2F4F4F solid;color:#fff;text-align:center;font-size:16px;font-family:"微软雅黑";}
.menu_nav a{text-decoration:none;color:#fff;}
.menu_nav a:hover{background:#009999;color:#fff;text-decoration:none;}



-->
</style>
<script type="text/javascript" src="js/jquery-1.4.js">
	
</script>

<script type="text/javascript" >
	$(document).ready(function(){
		$("a").click(function(){
			$(".current").removeClass();
			$(this).parent("li").addClass("current");
		})
	});
</script>

  </head>
  <body style="vertical-align:inherit; background-repeat:no-repeat" bgColor="#c0c0c0">
  <table cellSpacing=0 cellPadding=0 width="100%" 
 border=0 >
  <tr>
  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  <td>
    <div style="clear:both"></div><!-- 清除浮动 -->
    <div class="menu_navcc">
      <div class="menu_nav clearfix">
        ${navString }

      </div>
    </div>
    <!--nav,end-->
    </td>
    </tr>
    </table>
  </body>
</html>   
  
