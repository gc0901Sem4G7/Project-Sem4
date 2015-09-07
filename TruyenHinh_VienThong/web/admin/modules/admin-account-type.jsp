<%@page import="doituong.FQA"%>
<%@page import="doituong.Order"%>
<%@page import="model.admin.AdminDealerModel"%>
<%@page import="doituong.Dealer"%>
<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
  
  <%
    String admin = request.getSession().getAttribute("admin") + "";
    String mien = request.getSession().getAttribute("mien") + "";
  %>
  
    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
        <div class="container-fluid">
            
            <div class="row" style="margin-right: 10px;">

                <form action="register" method="POST" role="form" style="width: 80%; margin: auto;">
                    <a href="account-user" id="taiKhoanUser"><legend class="green">Tài khoản Người dùng</legend></a>
                    
                    <% if (mien.equals("admin")) { %>
                      <a href="account-admin" id="taiKhoanAdmin"><legend class="green">Tài khoản của Quản trị và Đại lý</legend></a>
                    <% } %>
                </form>
            </div>
            
        </div>

        <br> <br>

    </div>
    
    <script type="text/javascript">
      
    </script>
                
    </body>
</html>