<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
<link rel="stylesheet" type="text/css" href="css/button_style.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<!--The following script tag downloads a font from the Adobe Edge Web Fonts server for use within the web page. We recommend that you do not modify it.--><script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/andika:n4:default.js" type="text/javascript"></script>
</head>
<body>
<div class=header>
<table width="100%">
<tr>
<td width="48%"><a href="m_info.jsp" class=link1>Personal Information</a></td>
<td width="37%"><a href="m_emp.jsp" class=link1>Subordinate</a></td>
<td width="15%">
	<form name="back" action="Login.jsp">
		<input type="button" name="logout" class="btn-style2" value="Logout" onclick="javascript:back.submit();"/>
	</form>
</td>
</tr>
</table>
</div>


</body>
</html>