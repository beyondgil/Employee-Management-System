<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="datastructure.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%int num=Integer.parseInt(request.getParameter("no"));
	ArrayList<Manager> man=new ArrayList<Manager>();
	man=(ArrayList<Manager>)session.getAttribute("Manager");
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
  <h1><%=man.get(num).getDepartment() %></h1>
  <hr>
<table>
<tr>
	<td class="title">Manager:</td>
	<td class="info"><%=man.get(num).getName() %></td>
</tr>

<tr>
	<td class="title">Employee:</td>
	<td class="info"><%
	for(int i=0;i<(man.get(num).getEmployee().size());i++){
		out.println(man.get(num).getEmployee().get(i).getName());
		out.println("<br/>");
	}
	%></td>
</tr>
</table>
<input type="button" name="update" class="btn-style" value="Update" onclick="window.location.href('addform.jsp')"/>
<input type="button" name="delete" class="btn-style" value="Delete" onclick=""/>
</div>
 </body>
</html>
