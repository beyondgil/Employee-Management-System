<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="datastructure.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!ArrayList<Employee> emp=new ArrayList<Employee>();
%>
<%emp=(ArrayList<Employee>)session.getAttribute("Employee");
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Welcome_Admin</title>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" />
</head>
<body>
<div> <jsp:include page="admin_header.jsp"/></div>
<!--  <div class=info_box>
<table width="100%">
<col width="80%"><col width="20%">
<tr>
<td><input type='text' name='epysearchcontent' size="75"/></td>
<td><input type=button value=Search  class="btn-style" onclick="" /></td>
</tr>
</table>
</div>-->
<div class=info_box>
<table width="100%">
<col width="25%"><col width="25%"><col width="25%"><col width="25%">
<tr>
<%for (int i=0;i<emp.size();i++){ %>
<td><a href="admin_employee_info.jsp?num=<%=i%>" class=link_name><%=emp.get(i).getName() %></a></td>
<%if ((i+1)%4==0) out.println("</tr><tr>");%>
<%} %>
</tr>
</table>
</div>
<div class=info_box>
<form action=addform.jsp method=post name="adminadd" >
<input type="button" name="add" class="btn-style" value="Add" onclick="javascript:adminadd.submit();"/>
</form>
</div>

</body>
</html>




