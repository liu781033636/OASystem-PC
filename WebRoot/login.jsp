<%@ page contentType="text/html;charset=UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE>用户登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
  <style type="text/css">
  <!-- -->
body{background:url(images/background.jpg) center center;background-size:cover;height:600px;width:100%; 
filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='bg.jpg', sizingMethod='scale');
-moz-background-size:100% 100%;
background-size:100% 100%;
}
 
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery/jquery.js"></script>
<link rel="stylesheet" href="css/box_onfocus.css" type="text/css">
<script language="javascript" src="<%=basePath%>js/public.js"></script>
</HEAD>
<BODY onload=document.loginForm.j_username.focus(); bgColor=#002779 >
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%"  align=middle
border=0 >
  <TR>
    <TD align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0  bgColor=#303030>
        <TR>
        <TR>
          <TD align=middle><font size=6 color=white style="font-family: 微软雅黑">OA 办公自动化系统</font></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#303030 border=0>
        <TR>
         
          <TD align=middle>
            <TABLE cellSpacing=0 cellPadding=0 width=230 border=0 >
            
            <form method="post" id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/j_spring_security_check" >
              <TR height=5>
                <TD width=5></TD>
                <TD width=56></TD>
                <TD></TD></TR>
              <TR height=36>
                <TD></TD>
                <TD> <font color=white style="font-family: 微软雅黑">username:</font></TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                  maxLength=30 size=24   name="j_username" id="j_username"  class="j_username" type="text" autocomplete="on"></TD></TR>
              <TR height=36>
                <TD>&nbsp; </TD>
                <TD><font color=white style="font-family: 微软雅黑">passowrd: </font></TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                  type=password maxLength=30 size=24  
                name="j_password" id="j_password"></TD></TR>
              <TR height=5>
                <TD colSpan=3></TD></TR>
              <TR height=5>
                <TD colSpan=3></TD></TR>

              <TR>
            
                <TD colSpan=3>
                  <img src="images/sign in.png" onclick="javascript:document.loginForm.submit()"></img>
                  </TD></TR></FORM></TABLE></TD>
          <TD ></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD align=right></TD></TR></TABLE></TD></TR></TABLE></BODY></HTML>
