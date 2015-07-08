

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" rel="stylesheet">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			Truyền Hình Viễn Thông
		</div>
		
		<div id="login">
			<form action="login" method="POST" role="form">
				<legend>Login Admin</legend>
				<span style="color: red;">
					<%
					String status = request.getAttribute("status") + "";
					if (status.equals("Login Failure")) {
						out.print(status);
						out.print("<br>");
						out.print("<br>");
					}
					%>
				</span>
				
				
				<div class="form-group">
					<label for="">Username</label>
					<input type="text" class="form-control" name="username" id="" placeholder="Input field">
				</div>

				<div class="form-group">
					<label for="">Password</label>
					<input type="text" class="form-control" name="password" id="" placeholder="Input field">
				</div>
			
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
		</div>
	</div>
</body>
</html>