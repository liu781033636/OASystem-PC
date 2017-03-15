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
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="<%=basePath%>css/vip.css" type="text/css">
		<link rel="stylesheet" href="css/box_onfocus.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>js/jquery/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/security.js"></script>
		 <script type="text/javascript" src="<%=basePath%>js/annoucement.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/oddEvenColor.js"></script>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/highLight.js"></SCRIPT>
		<SCRIPT type="text/javascript" src="<%=basePath%>js/addTableAlign.js"></SCRIPT>
		<script language="javascript" src="<%=basePath%>js/public.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
		<title>上传文档</title>
	</head>

	<body>
		<form action="persons/File/file_update" method="post"
			enctype="multipart/form-data">
			<table class="title addTable">
			<input type="hidden" name="fileId" value="${files.id}" />
				<tr>
					<td>
						修改文档
					</td>
				</tr>
			</table>
			<table class="addTable">
				<tr>
					<td>
					</td>
				</tr>

				<tr>

				</tr>
				<tr>
					<td>
						文档名
					</td>
					<td>
						<c:out value="${files.title}" />
					</td>
				</tr>
				<tr>
					<td>
						文本内容
					</td>
					<td>
						<textarea cols="60" rows="10" name="filesContent" class="itemname" >${filesContent}</textarea>
					</td>
				</tr>

				<tr>
					<td>
						备注
					</td>
					<td>
						<textarea cols="60" rows="4" name="files.content" class="itemname" >${files.content}</textarea>
					</td>
				</tr>
			</table>
			<table class="btn">
				<tr>
					<td>
						<input type="submit" name="submit" value="发送" class="frm_btn" id="SYS_SET"/>
					</td>
				</tr>
			</table>
		</form>
        <br>
		<SCRIPT type=text/javascript>
            $(document).ready(registerPre);
        </SCRIPT>
	</body>
	</body>
</html>
