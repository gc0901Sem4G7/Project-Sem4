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
        List<Dealer> listDealer = (List<Dealer>) request.getAttribute("listDealer");
    %>
    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
        <div class="container-fluid">
            
            <div class="row" style="margin-right: 10px;">
                <label class="green">Danh sách Đại lý</label>
                <%
                if (listDealer!=null) {
                %>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            
                            <th>Tên đăng nhập</th>
                            <th>Mật khẩu</th>
                            <th>Họ và tên</th>
                            <th>Giới tính</th>
                            <th>Email</th>
                            <th>Điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Miền</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        for (Dealer obj : listDealer) {
                            if(!obj.getMien().equals("admin")) {
                        %>
                        <tr>
                            
                            <td><%= obj.getUsername()%></td>
                            <td><%= obj.getPassword()%></td>
                            <td><%= obj.getName()%></td>
                            <td><%= obj.getSex()%></td>
                            <td><%= obj.getEmail()%></td>
                            <td><%= obj.getPhone()%></td>
                            <td><%= obj.getAddress()%></td>
                            <td><%= obj.getMien()%></td>
                            <td><a href="account-admin?action=edit&id=<%= obj.getId() %>">Sửa</a></td>
                            <td><a href="account-admin?action=delete&id=<%= obj.getId() %>" onclick="return deleteDealer(this);">Xóa</a></td>
                        </tr>
                        <%
                        } }
                        %>
                    </tbody>
		</table>
                <%
                } else {
                %>
                <p>Không có Đại lý nào</p>
                <%
                }
                %>
            </div>
            <a href="pageAddDealer" class="btn btn-primary">Thêm Đại lý Mới</a>
        </div>
            <script>
                function deleteDealer(obj) {
                     if (!confirm("Bạn chắc chắn muốn xóa?")) {
                         return false;
                     }
                }
            </script>
        <br> <br>

    </div>
    
    </body>
</html>