<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
 <head>
  <title>User01</title>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" /> 
 </head>
 
 <body>
 <div class=info_box>
 <input type="button" name="Back_epylist" class="btn-style" value="Back" onclick="javascript :history.back(-1);"/>
</div>
 <div class=info_box>
  <h1>User01</h1>
  <hr>
<table>
<tr>
	<td class="title">Name:</td>
	<td class="info">user1</td>
</tr>
<tr>
	<td class="title">ID:</td>
	<td class="info">E001</td>
</tr>
<tr>
	<td class="title">Salary:</td>
	<td class="info">10000</td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td class="info">999-999-9999</td>
</tr>

<tr>
	<td class="title">Email:</td>
	<td class="info">122232131233@123.com</td>
</tr>

<tr>
	<td class="title">department:</td>
	<td class="info">IT<br>Selling</td>
</tr>
<tr>
	<td class="title">manager:</td>
	<td class="info">Tom</td>
</tr>
</table>
<input type="button" name="update" class="btn-style" value="Update" onclick="window.location.href('addform.jsp')"/>
<input type="button" name="delete" class="btn-style" value="Delete" onclick=""/>
</div>
 </body>
</html>
