<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" import="datastructure.*,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%int i=Integer.parseInt(request.getParameter("temp")); 
	ArrayList<Request> req=new ArrayList<Request>();
	req=(ArrayList<Request>)session.getAttribute("Request");
	Request t_req=new Request();
	t_req=req.get(i);

%>
<html lang="en">
 <head>
  <title>Request</title>
  <link rel="stylesheet" type="text/css" href="css/user_info.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" />
 </head>
 
 <body>
 <div> <jsp:include page="admin_header.jsp"/></div>
 <div class=info_box>
<table width="100%">
<col width="80%"><col width="20%">
 <tr>
  <td><h1><span id="txt"></span> <font color="#ff0033">Request_<%=i+1 %></font></h1></td>
  <td><input type="button" name="Back_epylist" class="btn-style" value="Back" onclick="javascript :history.back(-1);"/></td>
 </tr>
 </table>
 <hr>
<table>
<tr>
	<td class="title">Name:</td>
	<td class="info"><%=t_req.getName() %></td>
</tr>
<tr>
	<td class="title">ID:</td>
	<td class="info"><%=t_req.getEmp_id() %></td>
</tr>
<tr>
	<td class="title">Salary:</td>
	<td class="info"><%=t_req.getSalary() %></td>
</tr>
<tr>
	<td class="title">Phone:</td>
	<td class="info"><%=t_req.getPhone() %></td>
</tr>

<tr>
	<td class="title">Email:</td>
	<td class="info"><%=t_req.getEmail() %></td>
</tr>

<tr>
	<td class="title">Department:</td>
	<td class="info">
	<%for(i=0;i<(t_req.getDepartment().size());i++){
		
		out.println(t_req.getDepartment().get(i));
		out.println("<br/>");
	} %>
	</td>
</tr>


<tr>
<td>
<form action=RequestAgree?tem=<%=i%> method=post name="agree" >
<input type="button" name="agree" class="btn-style" value="Agree" onclick="javascript:agree.submit();"/>
</form>
</td>
<td>
<form action=RequestDisagree method=post name="disagree" >
<input type="button" name="disagree" class="btn-style" value="Disagree" onclick="javascript:disagree.submit();"/>
</form>
</td>
</tr>
</table>

</div>
 </body>
</html>
