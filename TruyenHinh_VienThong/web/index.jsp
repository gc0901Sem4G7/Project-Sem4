<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	
	<%
		String url = request.getRequestURL().toString();
		String tenMenu = request.getAttribute("tenMenu") + "";
	%>

	<div class="wrapper">
		<div class="body">
			<jsp:include page="modules/banner.jsp" />
			<br>

			<jsp:include page="modules/menu.jsp" />
			<br><br>
			
			<div class="content" id="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 5px;">
								<img class="img-responsive" src="img/content-left.jpg" alt="">
							</div>
							
							
							
							<%
								if (url.endsWith("TruyenHinh_VienThong") || url.endsWith("TruyenHinh_VienThong/")) {
							%>
								<jsp:include page="modules/content-middle-trang-chu.jsp" />
							<%
								} else if (tenMenu.equals("Cac goi dich vu")) {
							%>
								<jsp:include page="modules/content-middle-cac-goi-dich-vu.jsp" />
							<%
								} else if (tenMenu.equals("Gop y")) {
							%>
								<jsp:include page="modules/content-middle-gop-y.jsp" />
							<%
								} else if (tenMenu.equals("FQA")) {
							%>
								<jsp:include page="modules/content-middle-FQA.jsp" />
							<%
								} else if (tenMenu.equals("Lien he")) {
							%>
								<jsp:include page="modules/content-middle-lien-he.jsp" />
							<%
								} else if (tenMenu.equals("register")) {
							%>
								<jsp:include page="modules/content-middle-register.jsp" />
							<%
								} else if (url.endsWith("index.jsp")) {
							%>
								<jsp:include page="modules/content-middle-trang-chu.jsp" />
							<%
								}
							%>
							
						</div>


						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" id="form-dang-ky">

							<div class="panel panel-default">

								<div class="panel-heading bg-info">
								
									<%
										String username = request.getSession().getAttribute("username") + "";
										if (!"".equals(username) && !"null".equals(username)) {
									%>
										<table class="table table-hover">
											<thead>
												<tr>
													<th> <%
															 String message = request.getAttribute("message") + "";
															 if (!message.equals("null")) out.print(message);
														%>
															 
													</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Welcome <a href="#"><%= username %></a> to website</td>
												</tr>
												<tr>
													<td></td>
													<td><a href="logout">Logout</a></td>
												</tr>
											</tbody>
										</table>
									<%
										} else {
									%>
								
										<form action="login" method="post" class="form-inline" role="form">

											<h3>
												<small>
													<%
														String message = request.getAttribute("message") + "";
														if (!message.equals("null")) {
															out.print(message);
														}
													%>
												</small>
											</h3>

											<div class="form-group">
												<label for="username"><span class="infomation">Username:</span></label>
												<input type="text" class="form-control" name="username" id="username" placeholder="enter username here">
											</div>
	
											<div class="form-group" style="margin-bottom: 10px;">
												<label for="password"><span class="infomation">Password:</span></label>
												<input type="password" class="form-control" name="password" id="password" placeholder="enter password here">
											</div>
											<br>

											<br>
											
											<div class="checkbox" style="margin-bottom: 10px;">
												<label><a href="register"> Register</a></label>
											</div>
											
											<br>
											<button type="submit" class="btn btn-warning" style="width: 100%;">Login</button>
										</form>
									<%
										}
									%>
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>

			<jsp:include page="modules/footer.jsp" />

		</div>
	</div>

	<script src="//code.jquery.com/jquery.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>