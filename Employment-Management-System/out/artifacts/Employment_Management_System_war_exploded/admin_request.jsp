<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="datastructure.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!

%>
<%ArrayList<Request> req=new ArrayList<Request>();
	req.clear();
	req=(ArrayList<Request>)session.getAttribute("Request");
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
 
<div class=info_box>
<table width="100%">
<col width="70%"><col width="30%">
<%for(int i=0;i<req.size();i++){ %>
<tr>
	<td class="title"><a href="requestdetail.jsp?temp=<%=i%>"  name=countnum onclick="javascript:req.submit();">Request_<%=i+1%></a></td>
	<td class="info" name=<%="req,"+i%>=i%>from <%=req.get(i).getName() %></td>
</tr>
<%} %>
</table>
</div>


<!-- 
<div class=info_box>
<h2> New Update in 5 Days</h2>
<hr>
<table width="100%">
<col width="70%"><col width="30%">
<tr>
	<td class="title">Update01</td>
	<td class="info">Date</td>
</tr>
</table>
</div>
 -->

</body>
</html>




