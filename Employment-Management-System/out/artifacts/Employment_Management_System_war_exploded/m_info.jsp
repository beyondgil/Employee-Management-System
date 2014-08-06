<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="datastructure.Manager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! Manager user;
	int i=0;
%>
<html lang="en">
 <head>
 <%user=(Manager)session.getAttribute("user_m");
	if(user==null){ 
 user=(Manager)request.getAttribute("man");
 request.getSession().setAttribute("user_m", user);
	}
 %>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus�">
  <meta name="Author" content="Jun Hu">
  <meta name="Keywords" content="employee">
  <meta name="Description" content="employee page">
  <title>Welcome_User1</title>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <script type="text/javascript">
	function showtime(){
	var today=new Date();  
	var h=today.getHours();
	if(h<12){
	document.getElementById('txt').innerHTML="Good Morning";}
	else if(h<18){document.getElementById('txt').innerHTML="Good Afternoon";}
	else{document.getElementById('txt').innerHTML="Good Evening";}
}

</script>
  
 </head>

 <body onload="showtime()">
 <div> <jsp:include page="m_header.jsp"/></div>
 <div class=info_box>
  <h1><span id="txt"></span> <%=user.getName() %></h1>
  <hr>
<table width="100%">
<col width="40%"><col width="60%">
<tr>
	<td class="title">Name:</td>
	<td class="info"><%=user.getName() %></td>
</tr>
<tr>
	<td class="title">ID:</td>
	<td class="info"><%=user.getEmp_id() %></td>
</tr>
<tr>
	<td class="title">Salary:</td>
	<td class="info"><%=user.getSalary() %></td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td class="info"><%=user.getPhone() %></td>
</tr>

<tr>
	<td class="title">Email:</td>
	<td class="info"><%=user.getEmail()  %></td>
</tr>

<tr>
	<td class="title">department:</td>
	<td class="info"><%
	
		
		out.println(user.getDepartment());
	
	%></td>
</tr>

</table>
<form action=Managerchange.jsp method=post name=emp >
<input type="button" name="change" class="btn-style" value="Change Personal Information" onclick="javascript:emp.submit();"/>
</form>
</div>
 </body>
</html>
