<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="datastructure.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%! Employee user;
	int i=0;
%>
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus�">
  <meta name="Author" content="Jun Hu">
  <meta name="Keywords" content="change">
  <meta name="Description" content="change">
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" />
  <title>Change</title>
     <script type="text/javascript" src="JS/jquery.js"></script>
     <script type="text/javascript" src="JS/info_change.js"></script>


 </head>
 <body>
 	<% user=(Employee)session.getAttribute("user");
 		System.out.println(user.getName());
 	%>
 <div> <jsp:include page="emp_header.jsp"/></div>
 <div class=info_box>
  <h1>Information Change Request </h1>
  <hr>
<form action=EmployeeRequestHandle name=form1 method=post>
<table>
<tr>
	<td class="title">Salary:</td>
	<td><input class='text1' name='Salary' type='text' size="30"/></td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td><input class='text1' name='Phone' type='text' size="30"/></td>
</tr>

<tr>
	<td class="title">E-mail:</td>
	<td><input class='text1' name='email' type='text' size="30"/><div class="warning" id="div_email" style="display:inline">
</div> </td>

</tr>


<tr>
	<td class="title">department:</td>
	  <td>
    <label><input name="department" type="checkbox" value="11111" onclick="getcheck();" />Human Resources </label>
	<label><input name="department" type="checkbox" value="21111" onclick="getcheck();" />Technology </label>
    <label><input name="department" type="checkbox" value="31111" onclick="getcheck();" />Marketing </label>
    <label><input name="department" type="checkbox" value="41111" onclick="getcheck();" />Finance </label>
	  </td>
</tr>
<tr>
	<td  class="title">manager:</td>
	<td><div class="info" id="show_m"></div></td>
</tr>

  </tr>
    <tr>
	<td><input type="button" class="btn-style" value="Submit"  onclick="show_confirm();return false;"   ></td>
	<td><input type="button" class="btn-style" value="Reset"  onclick="javascript:form1.reset(); return false;"></td>
  </tr>
  </table>
</form>
</div>
 </body>