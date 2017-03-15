
<%@ page contentType="text/html;charset=UTF-8" import="com.security.model.User,org.springframework.security.context.SecurityContextHolder"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
  <base href="<%=basePath%>">
<META http-equiv=Content-Type content="text/html; charset=utf-8">
 <LINK href="css/admin.css" type="text/css" rel="stylesheet">

</HEAD>
<BODY bgColor="#c0c0c0">
<TABLE cellSpacing=0 cellPadding=0 width="100%" 
 border=0 bgColor="#c0c0c0">
  <TR height=56>
    <td>&nbsp;&nbsp;&nbsp;<img src="images/ntu2.jpg"  width="48" height="48" border="0"></td><td width=150>&nbsp;&nbsp;&nbsp;</td><td><IMG height=62 src="images/bangong3.png" 
    width=350></td>
    <TD 
      align=middle><font style="font-family: 微软雅黑">当前用户：<%=user.getEmployee().getEmpName() %> &nbsp;&nbsp; </font><A  
      href="" 
      target=main></A> &nbsp;&nbsp; <A 
      onclick="if (confirm('确定要退出吗？')) return true; else return false;" 
      href="${pageContext.request.contextPath}/j_spring_security_logout" target=_top><font style="font-family: 微软雅黑">退出系统</font></A> 
    </TD>
   
  </TR></TABLE>
</BODY></HTML>