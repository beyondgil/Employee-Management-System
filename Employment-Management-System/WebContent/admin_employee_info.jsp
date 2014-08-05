<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="datastructure.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%int num=Integer.parseInt(request.getParameter("num"));
	ArrayList<Employee> emp=new ArrayList<Employee>();
	emp=(ArrayList<Employee>)session.getAttribute("Employee");
%>
<html lang="en">
 <head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" /> 
 </head>
 
 <body>
 <div class=info_box>
 <input type="button" name="Back_epylist" class="btn-style" value="Back" onclick="javascript :history.back(-1);"/>
</div>
 <div class=info_box>
  <h1><%=emp.get(num).getName() %></h1>
  <hr>
<table>
<tr>
	<td class="title">Name:</td>
	<td class="info"><%=emp.get(num).getName() %></td>
</tr>
<tr>
	<td class="title">ID:</td>
	<td class="info"><%=emp.get(num).getEmp_id() %></td>
</tr>
<tr>
	<td class="title">Salary:</td>
	<td class="info"><%=emp.get(num).getSalary() %></td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td class="info"><%=emp.get(num).getPhone() %></td>
</tr>

<tr>
	<td class="title">Email:</td>
	<td class="info"><%=emp.get(num).getEmail() %></td>
</tr>
<tr>
	<td class="title">department:</td>
	<td class="info"><%
	for(int i=0;i<(emp.get(num).getDepartment().size());i++){
		
		out.println(emp.get(num).getDepartment().get(i));
		out.println("<br/>");
	}
	%></td>
</tr>
<tr>
	<td class="title">manager:</td>
	<td class="info"><%
	for(int i=0;i<(emp.get(num).getManager().size());i++){
		
		out.println(emp.get(num).getManager().get(i).getName());
		out.println("<br/>");
	}
	%></td>
</tr>
</table>
<form action=updateform.jsp?temEU=<%=num%> method=post name="adminupdate" >
<input type="button" name="up" class="btn-style" value="Update" onclick="javascript:adminupdate.submit();"/>
</form>
<form action=AdminEmpDelete?temED=<%=num%> method=post name="admindelete" >
<input type="button" name="de" class="btn-style" value="Delete" onclick="javascript:admindelete.submit();"/>
</form>
</div>
 </body>
</html>
