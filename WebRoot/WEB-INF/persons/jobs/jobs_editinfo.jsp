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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">

	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="<%=basePath%>css/vip.css" type="text/css">
		<link rel="stylesheet" href="css/box_onfocus.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>js/jquery/jquery.js"></script>
		 <script type="text/javascript" src="<%=basePath%>js/persons.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/oddEvenColor.js"></script>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/highLight.js"></SCRIPT>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/addTableAlign.js"></SCRIPT>
		<script language="javascript" src="<%=basePath%>js/public.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
	<title>修改职位</title>
</head>

<body>
	<form action="persons/jobs/jobs_update" method="post">
		<input type="hidden" name="jobs.id" value="${jobs.id}">

		<table class="title addTable">
			<tr>
				<td>修 改 职 位
				</td>
			</tr>
</table>
<table class="addTable">
			<tr>
				<td> 职位名称 
				</td>
				<td>
					<input align="left" type="text" name="jobs.jobsName "
						value="${jobs.jobsName}" class="checkEmptyShowInfo" id="jobsjobsName"/><font color="#FF0000">*</font>
						<span  id="checkjobsjobsName" style="color: #FF0000; font-size: 12px;" ></span>
				</td>
			</tr>


			<tr>
				<td> 职位描述 
				</td>
				<td>
					<textarea name="jobs.jobsDes" cols="50" rows="3" class="itemname">${jobs.jobsDes}</textarea>
				</td>
			</tr>
			
			<tr>
				<td>审批等级</td>
				<td>
										<select name="jobs.level">
							
							<option
								<c:if test="${jobs.level=='0' }">selected="selected"</c:if>
								value="0">
								无权限
							</option>
							<option
								<c:if test="${jobs.level=='1' }">selected="selected"</c:if>
								value="1">
								确认权限
							</option>
							<option
								<c:if test="${jobs.level=='2' }">selected="selected"</c:if>
								value="2">
								审批权限
							</option>



						</select>
				</td>
			</tr>
			</table><table class="btn">
			
			<tr>
				<td>
					<input type="submit" value="提交" class="frm_btn" id="SYS_SET"/>
				</td>
			</tr>
		</table>
	</form>
                       		<br>
		<SCRIPT type=text/javascript>
            $(document).ready(registerPre);
        </SCRIPT>
</body>
</html>
