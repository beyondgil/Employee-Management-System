<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<p>
							必要说明
						</p></div>
					<div class="info">
						<form action=employee_info.jsp method=post name="user"><!-- action 下一步的ULR-->
							 <header>
							  <h1>Login</h1>
							 </header>
							  <hr>
							  <table>
							  <tr>
								<td class="tag1">Username:</td>
								<td><input type='text' name='username' /></td>
							  </tr>
							  <tr>
								<td class="tag1">Password:</td>
								<td><input type='password' name='password'/></td>
							  </tr>
								<tr>
								<td><input type=image value=login src="images/Login.png" width=90 height=30 ></td>
							
								<td><input type="image" src="images/Reset.png" width=90 height=30  onclick="javascript:user.reset(); return false;" /></td>
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
						<p>
							必要说明
						</p>					
					</div>
					<div class="info">
						<form action= method=post name="admin"><!-- action 下一步的ULR-->
							 <header>
							  <h1>Login</h1>
							 </header>
							  <hr>
							  <table>
							  <tr>
								<td  class="tag1">Username:</td>
								<td><input type='text' name='username'/></td>
							  </tr>
							  <tr>
								<td  class="tag1">Password:</td>
								<td><input type='password' name='password'/></td>
							  </tr>
								<tr>
								<td><input type=image value=login src="images/Login.png" width=90 height=30 ></td>
								<td><input type="image" src="images/Reset.png" width=90 height=30  onclick="javascript:admin.reset(); return false;" /></td>
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