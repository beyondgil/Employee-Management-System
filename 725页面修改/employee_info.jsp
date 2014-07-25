<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
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
  <h1><span id="txt"></span> <font color="#ff0033">User1</font></h1>
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

<a href="change.html"><img src="images/CPI.png" width="249" height="40" border="0" alt=""></a>
 </body>
</html>
