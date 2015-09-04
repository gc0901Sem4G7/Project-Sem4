<%@page import="doituong.OrderByTenDichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@page import="doituong.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Danh sách đặt hàng chi tiết</title>
  <link rel="stylesheet" href="css/style.css" type="text/css">
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
  <%
  User user = (User) request.getAttribute("user");
  if (user != null) {
  %>
  <table class="table table-bordered table-hover" style="width: 70%;">
    <thead>
      <tr>
        <th colspan="5">Thông tin <%= user.getUsername()%></th>
      </tr>
      <tr>
        <th>Username</th>
        <th>Họ tên</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th><%= user.getUsername() %></th>
        <th><%= user.getName() %></th>
        <th><%= user.getPhoneNumber() %></th>
        <th><%= user.getEmail() %></th>
        <th><%= user.getAddress() %></th>
      </tr>
    </tbody>
  </table>
  
  <% } %>
      
  <%
    List<Order> listOrder = (List<Order>) request.getAttribute("listOrder");
  %>
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
    <div class="container-fluid">

      <div class="row" style="margin-right: 10px;">
        <label class="green">Danh sách đặt hàng theo username</label>
        <%
        if (listOrder!=null) {
        %>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Tên dịch vụ</th>
                    <th>Miền</th>
                    <th>Địa chỉ nắp đặt</th>
                    <th>Thời lượng</th>
                    <th>Giá tiền</th>
                    <th>Status</th>
                    <th>Date Register</th>
                    <th>Date End</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (Order obj : listOrder) {
                %>
                <tr>
                  <td><%= obj.getUsername()%></td>
                  <td><%= obj.getTenDichVu() %></td>
                  <td><%= obj.getMien() %></td>
                  <td><%= obj.getDiaChiNapDat() %></td>
                  <td><%= obj.getThoiLuong() %></td>
                  <td><%= obj.getGia() %></td>
                  <td><%= obj.getStatus() %></td>
                  <td><%= obj.getDateRegister() %></td>
                  <td><%= obj.getDateEnd() %></td>
                </tr>
                <%
                }    
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <p></p>
        <%
        }
        %>
      </div>
    </div>

    <br> <br>

  </div>
      558
      
  <%
        
    List<OrderByTenDichVu> listOrderByTenDichVu = (List<OrderByTenDichVu>) request.getAttribute("listOrderByTenDichVu");
  %>
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px; width: 70%;">
    <div class="container-fluid">

      <div class="row" style="margin-right: 10px;">
        <label class="green">Danh sách đặt hàng theo tên dịch vụ</label>
        <%
        if (listOrderByTenDichVu!=null) {
        %>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Tên dịch vụ</th>
                    <th>Thời lượng</th>
                    <th>Giá tiền</th>
                    <th>Thành tiền</th>
                    <th>Địa chỉ nắp đặt</th>
                    <th>Mô tả</th>
                    <th>Trạng thái</th>
                    <th>Ngày đăng ký</th>
                    <th>Ngày kết thúc</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (OrderByTenDichVu obj : listOrderByTenDichVu) {
                %>
                <tr>
                  <td><%= obj.getUsername()%></td>
                  <td><%= obj.getTenDichVu() %></td>
                  <td><%= obj.getThoiLuong()%></td>
                  <td><%= obj.getGiaDichVu()%></td>
                  <td><%= obj.getThanhTien()%></td>
                  <td><%= obj.getDiaChiNapDat()%></td>
                  <td><%= obj.getMoTa()%></td>
                  <td><%= obj.getTrangThai()%></td>
                  <td><%= obj.getDateBegin()%></td>
                  <td><%= obj.getDateEnd() %></td>
                </tr>
                <%
                }    
                %>
            </tbody>
        </table>
        <%
        } else {
        %>
        <p></p>
        <%
        }
        %>
      </div>
    </div>

    <br> <br>

  </div>

  </body>
</html>