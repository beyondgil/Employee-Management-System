<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin_Header</title>
<link rel="stylesheet" type="text/css" href="css/button_style.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<script type="text/javascript" src="JS/jquery.js"></script>
<script type="text/javascript" src="JS/logout_conf.js"></script>
<script type="text/javascript" src="JS/download_excel.js"></script>
</head>
<body>

<div class=header>
<table width="100%">
<tr>
<td width="20%"><a href="admin_request.jsp" class=link1>Request</a></td>
<td width="20%"><a href="employee_list.jsp" class=link1>Employee</a></td>
<td width="23%"><a href="department_list.jsp" class=link1>Department</a></td>
<td width="17%"><input type="button"  class="btn-style2" value="Excel" onclick="javascript:download_excel();"/></td>
<td width="20%"><form id="back" action="Login.jsp"><input type="button" name="logout" class="btn-style2" value="Logout" onclick="javascript:logout_conf();"/></form></td>
</tr>
</table>
</div>


</body>
</html>

