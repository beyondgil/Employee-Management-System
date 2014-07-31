<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" />
  <title>Add Form</title>
<script type="text/javascript">
	function show_confirm()
	{	var info_check=check();
	if(info_check==true){

	var r=confirm("Do you want to change your Information!");
	if (r==true)
	  {
	  alert("You pressed OK!");
	  form1.submit();
	  }
	else
	  {
	  return false;
	  }
	}
	}

	function check(){
		return checkEmail();

	}
		function checkEmail(){ 
		var div = document.getElementById("div_email"); 
		div.innerHTML = ""; 
		var email = document.form1.email.value; 
		var sw = email.indexOf("@", 0); 
		var sw1 = email.indexOf(".", 0); 
		var tt = sw1 - sw; 
		if (email.length == 0) { 
		div.innerHTML = "email cannot empty"; 
		document.form1.email.focus(); 
		return false; 
		} 
		if (email.indexOf("@", 0) == -1) { 
		div.innerHTML = "format error"; 
		document.form1.email.select(); 
		return false; 
		} 
		if (email.indexOf(".", 0) == -1) { 
		div.innerHTML = "format error"; 
		document.form1.email.select(); 
		return false; 
		} 
		if (tt == 1) { 
		div.innerHTML = "format error"; 
		document.form1.email.select(); 
		return false; 
		} 
		if (sw > sw1) { 
		div.innerHTML = "format error"; 
		document.form1.email.select(); 
		return false; 
		} 
			else { 
		return true; 
		} 

		return ture; 
		} 

</script>


 </head>
 <body>
 <div class=info_box>
 <input type="button" name="Back_epylist" class="btn-style" value="Back" onclick="javascript :history.back(-1);"/>
</div>
<div class=info_box>
<form action=login.jsp name=form1 method=post>
<table>
<tr>
	<td class="title">Name:</td>
	<td><input class='text1' name='Salary' type='text' size="30"/></td>
</tr>
<tr>
	<td class="title">Address:</td>
	<td><input class='text1' name='Salary' type='text' size="30"/></td>
</tr>
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
	<td><input class='text1' name='email' type='text' size="30"/><div id="div_email" style="display:inline"> 
</div> </td>
	
</tr>


<tr>
	<td class="title">department:</td>
	  <td>
	<label><input name="department" type="checkbox" value="IT" />IT </label>
	<label><input name="department" type="checkbox" value="Selling" />Selling </label>
    <label><input name="department" type="checkbox" value="Hiring" />Hiring </label>
    <label><input name="department" type="checkbox" value="A" />A </label>
	  </td>
</tr>
<tr>
	<td  class="title">manager:</td>
	<td><input class='text1' name='manager' type='text' size="30"/></td>
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