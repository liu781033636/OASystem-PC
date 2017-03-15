<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%=basePath%>js/jquery/jquery.js"></script>
    
    <title>My JSP 'sign_in.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
		
	-->
	<link rel="stylesheet" href="css/vip.css" type="text/css">


	
  </head>
  
  <body>
  	<table class="titleTable" >
   	<br/><form action="persons/attendance/attendance_signIn">
   	<tr>
   	   	<td style="text-align: right">

   	<input type="submit"  value="签到" 
   	<c:if test="${attendance.inTime!=null}">disabled="true"</c:if>
   	align="left">
   	</td>
   	<td style="text-align: left">
   	<c:choose>
   	<c:when test="${attendance.inTime==null}" >
   	您还未签到
   	</c:when>
   	<c:otherwise>
   	签到日期为
   	<fmt:formatDate value="${attendance.inTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
   	
   	</c:otherwise>
   	</c:choose>
   	</td>

   	</tr>
   	<tr><td>&nbsp;</td><td></td></tr>
   	</form>

	<tr></tr><tr></tr>	<tr></tr><tr></tr>
   	<br/><form action="persons/attendance/attendance_signOut">

   	<tr>
   	</td>
   	<td style="text-align: right">
   	<input type="submit" value="签退" align="left" >
   	</td>

   	<td style="text-align: left">
   	<c:choose>
   	<c:when test="${attendance.outTime==null}" >
   	您还未签退
   	</c:when>
   	<c:otherwise>
   	签退日期为
   	<fmt:formatDate value="${attendance.outTime}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
   	</c:otherwise>
   	</c:choose>

   	</tr>
   	</form>
   	</table>
	
	
  </body>
</html>
