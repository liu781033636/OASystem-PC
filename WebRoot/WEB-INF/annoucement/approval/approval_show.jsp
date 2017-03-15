<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="<%=basePath%>css/vip.css" type="text/css">
		<link rel="stylesheet" href="css/box_onfocus.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>js/jquery/jquery.js"></script>
		 <script type="text/javascript" src="<%=basePath%>js/warehouse.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/oddEvenColor.js"></script>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/highLight.js"></SCRIPT>
        <script language="javascript" src="<%=basePath%>js/textRightLeft.js"></script>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/addTableAlign.js"></SCRIPT>
		<script language="javascript" src="<%=basePath%>js/public.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">


</script>

		<title>发送消息</title>
	</head>

	<body>
       <form action="persons/approval/approval_appr">
       <input type="hidden" name="userId" value="${approval.sper.id}"/>
      <input type="hidden" name="approval.id" value="${approval.id}"/>
          <input type="hidden" name="approval.time" value="${approval.time}"/>  
		<table class="title" style="width:85%">
			<tr>
				<td>
					查看消息
				</td>
			</tr>
		</table>
		<table class="addTable">
			<tr>
				<td>
					申请人
				</td>
				<td>
					<input type="text"  readonly="readonly" align="left"
					
							value="${approval.sper.employee.empName}" />
					
				</td>
			</tr>

			<tr>
				<td>
					标 题
				</td>
				<td>
					<input type="text" readonly="readonly" align="left"
					name="approval.title"
							value="${approval.title}" />
					
				</td>
			</tr>



			<tr>
				<td>
					内 容
				</td>
				<td>
					<textarea name="approval.content" cols="50" rows="4" readonly="readonly"
						value="${approval.content}">${approval.content}</textarea>
				</td>
				
			</tr>
			<tr>
			<td>
					审批状态
				</td>
			<td>
						<select name="approval.status">
							
								<option selected="selected" value="${approval.status}">
									请选择
								</option>
							
					      <c:choose>

								<c:when test="${approval.status=='0'}">
							<option
								<c:if test="${approval.status=='1' }">selected="selected"</c:if>
								value="1">
								确认
							</option>
								</c:when>
								<c:when test="${approval.status=='1'}">
							<option
								<c:if test="${approval.status=='2' }">selected="selected"</c:if>
								value="2">
								通过
							</option>
								</c:when>
							</c:choose>
		
							<option
								<c:if test="${approval.status=='3' }">selected="selected"</c:if>
								value="3">
								拒绝
							</option>

						
						</select>
					</td>
			</tr>
			<tr>
				<td>
					备注
				</td>
				<td>
					<textarea name="approval.content2" cols="50" rows="4" 
						value="${approval.content2}">${approval.content2}</textarea>
				</td>
				
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<input type="submit" name="submit" value="回复" class="frm_btn"  />
                    
				</td>
			</tr>
		</table>
</form>
	</body>
</html>
