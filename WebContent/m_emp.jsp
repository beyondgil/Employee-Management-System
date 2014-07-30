<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="datastructure.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! Manager user;
	int i=0;
	Employee emp;
%>
<% 	
	user=(Manager)session.getAttribute("user_m"); %>

<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
   <link rel="stylesheet" type="text/css" href="css/meg_emp.css" />
  <title>Document</title>
 <!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.-->
 <script>var __adobewebfontsappname__="dreamweaver"</script>
 <script src="http://use.edgefonts.net/aladin:n4:default.js" type="text/javascript"></script>

 </head>
 
   
 <body>
 <jsp:include page="m_header.jsp"/>
  <%for(i=0;i<user.getEmployee().size();i++){ 
  emp=user.getEmployee().get(i);
  
  %>
 
 <div class=table1>
  <h1><%=emp.getName() %></h1>
  <table >
<tr>
	<td class="title">Name:</td>
	<td class="info"><%=emp.getName() %></td>
</tr>
<tr>
	<td class="title">ID:</td>
	<td class="info"><%=emp.getEmp_id() %></td>
</tr>
<tr>
	<td class="title">Salary:</td>
	<td class="info"><%=emp.getSalary() %></td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td class="info"><%=emp.getPhone() %></td>
</tr>

<tr>
	<td class="title">Email:</td>
	<td class="info"><%=emp.getEmail() %></td>
</tr>

</table>
 </div>
<%} %>

 </body>
</html>
