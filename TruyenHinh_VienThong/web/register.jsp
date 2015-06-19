<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>

	<div class="wrapper">
		<div class="body">
			<div class="banner" id="banner">
				<img class="img-responsive" src="img/banner.jpg" alt="">
			</div>
			<br>

			<div class="menu" id="menu">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<ul class="nav nav-pills">
								<li class=""><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Trang chủ</a></li>

								<li class=""><a href=""><span class="glyphicon glyphicon-transfer"></span> Tin tức</a></li>
								<li class=""><a href=""><span class="glyphicon glyphicon-user"></span> Thành viên mới</a></li>
								<li class=""><a href=""><span class="glyphicon glyphicon-send"></span> Góp ý</a></li>
								<li class=""><a href="lienHe.jsp"><span class="glyphicon glyphicon-envelope"></span> Liên hệ</a></li>
							</ul>
						</div>

					</div>
				</div>
			</div>
			<br> <br>
			<div class="content" id="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"
								style="padding: 5px;">
								<div class="panel panel-default" id="panel-left">
									<div class="panel panel-primary">
										<div class="panel-heading">Tìm bạn nữ</div>
									</div>

									<div class="panel panel-primary">
										<div class="panel-heading">Tìm sách bạn nam</div>
									</div>
								</div>

							</div>

							
						</div>


						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
							
							<form action="register" method="POST" role="form">
								<legend>Form Đăng Ký</legend>
							
								<div class="form-group">
									<label for="username">Username:</label>
									<input type="text" class="form-control" name="username" id="username" placeholder="Input field">
								</div>
							
								<div class="form-group">
									<label for="password">Password:</label>
									<input type="password" class="form-control" name="password" id="password" placeholder="Input field">
								</div>
								
								<div class="form-group">
									<label for="name">Name:</label>
									<input type="text" class="form-control" name="name" id="name" placeholder="Input field">
								</div>
							
								<div class="form-group">
									<label for="card_id">Card ID:</label>
									<input type="text" class="form-control" name="card_id" id="card_id" placeholder="Input field">
								</div>
								
								<div class="form-group">
									<label for="phone_number">Phone Number:</label>
									<input type="text" class="form-control" name="phone_number" id="phone_number" placeholder="Input field">
								</div>
							
								<div class="form-group">
									<label for="email">Email:</label>
									<input type="text" class="form-control" name="email" id="email" placeholder="Input field">
								</div>
								
								<div class="form-group">
									<label for="address">Address:</label>
									<input type="text" class="form-control" name="address" id="address" placeholder="Input field">
								</div>
								
								<div class="form-group">
									<label for="package_id">Package ID:</label>
									<input type="text" class="form-control" name="package_id" id="package_id" placeholder="Input field">
								</div>
							
								<div class="form-group">
									<label for="dealer_id">Dealer ID:</label>
									<input type="text" class="form-control" name="dealer_id" id="dealer_id" placeholder="Input field">
								</div>
							
								<button type="submit" class="btn btn-primary">Đăng ký</button>
							</form>

						</div>
						
						<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
						
						</div>
					</div>
				</div>
			</div>


			<div class="footer" id="footer">
				<div class="panel panel-default">
					<div class="panel-footer">
						<div class="container-fluid">
							<div class="row"></div>
						</div>
					</div>

					<img src="img/footer.jpg" alt="" class="img-responsive">
				</div>
			</div>




		</div>
	</div>

	<script src="//code.jquery.com/jquery.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>