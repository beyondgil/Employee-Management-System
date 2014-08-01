<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    		<%session.invalidate(); %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="css/normalize.css" />
  <link rel="stylesheet" type="text/css" href="css/flap.css" />
  <link rel="stylesheet" type="text/css" href="css/component.css" />
  <link rel="stylesheet" type="text/css" href="css/button_style.css" />
 </head>
 <body>
  <div class="container">
	<div class="wrapper">
		<ul class="stage clearfix">

			<li class="scene">
				<div class="movie" onclick="return true">
					<div class="poster">
						<header>
							<h1>User Entrance</h1>
						</header>
						</div>
					<div class="info">
						<form action=LoginCheck method=post name="user"><!-- action 下一步的ULR-->
							 <header>
							  <h1>Login</h1>
							 </header>
							  <hr>
							  <table>
							  <tr>
								<td width="125" class="tag1">Username:</td>
								<td width="120"><input type='text' name='username' /></td>
							  </tr>
							  <tr>
								<td class="tag1">Password:</td>
								<td><input type='password' name='password'/></td>
							  </tr>
							  <tr>
							  <td class="tag1" colspan="2"><label ><input name="rem" type="checkbox" value="rem" />Remember me </label></td></tr>
								<tr>
								<td><input type=button value=Login  class="btn-style" onclick="javascript:user.submit();" ></td>
							
								<td><input type="button" value="Reset" class="btn-style"  onclick="javascript:user.reset(); return false;" /></td>
							  </tr>
							  </table>

							</form>
					</div>
				</div>
			</li>

			<li class="scene">
				<div class="movie" onclick="return true">
					<div class="poster">
						<header>
							<h1>Admin Entrance</h1>
						</header>
									
					</div>
					<div class="info">
						<form action=AdminCheck method=post name="admin" name="admin"><!-- action 下一步的ULR-->
							 <header>
							  <h1>Login</h1>
							 </header>
							  <hr>
							  <table>
							  <tr>
								<td width="123"  class="tag1">Username:</td>
								<td width="125"><input type='text' name='username'/></td>
							  </tr>
							  <tr>
								<td  class="tag1">Password:</td>
								<td><input type='password' name='password'/></td>
							  </tr>
							  <tr>
							  <td class="tag1" colspan="2"><label ><input name="rem" type="checkbox" value="rem" />Remember me </label></td></tr>
								<tr>
								<td><input type=button value=Login  class="btn-style" onclick="javascript:admin.submit();"></td>
								<td><input type="button" value="Reset" class="btn-style"  onclick="javascript:admin.reset(); return false;" /></td>
							  </tr>
							  </table>
							</form>
					</div>
				</div>
			</li>
		</ul>
	</div><!-- /wrapper -->
</div>
 </body>
</html>