<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="doituong.OrderByTrangThai"%>
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
      String sendMailSuccess = request.getAttribute("sendMailSuccess") + "";
      String mien = request.getSession().getAttribute("mien") + "";
    %>
  
    <%
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String dateNow = dateFormat.format(new Date());
      String trangThai = "";
    %>
  
    <%
        List<OrderByTrangThai> listOrderByTrangThai = (List<OrderByTrangThai>) request.getAttribute("listOrderByTrangThai");
    %>
    
    <h2>Danh sách khách hàng khu vực miền <%= mien %></h2>
    <p style="color: #0C0;">
      <%
      if (!"".equals(sendMailSuccess) && !"null".equals(sendMailSuccess)) {
        out.print(sendMailSuccess);
      }
      %>
    </p>
    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
        <div class="container-fluid">
            
            <div class="row" style="margin-right: 10px;">
                <%
                if (listOrderByTrangThai!=null) {
                %>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Tên dịch vụ</th>
                            <th>Ngày bắt đầu</th>
                            <th>Ngày kết thúc</th>
                            <th>Email</th>
                            <th>Trạng thái</th>
                            <th>Gia hạn</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        for (OrderByTrangThai obj : listOrderByTrangThai) {
                        %>
                        <tr>
                          <td><a href="order?username=<%= obj.getUsername()%>"><%= obj.getUsername() %></a></td>
                            <td><a href="order?tenDichVu=<%= obj.getTenDichVu()%>"><%= obj.getTenDichVu() %></a></td>
                            <td><%= obj.getDateRegister() %></td>
                            <td><%= obj.getDateEnd() %></td>
                            <td><%= obj.getEmail() %></td>
                            <td>
                              <%
                  
                    int tt = (obj.getDateEnd() + "").compareTo(dateNow + "");
                    
                    if (
                         (
                           (obj.getDateEnd() + "").substring(0, 4).equals((dateNow).substring(0, 4)) &&
                           Integer.parseInt((obj.getDateEnd() + "").substring(5, 7)) - Integer.parseInt(dateNow.substring(5, 7)) == 0 &&
                           (obj.getDateEnd() + "").substring(8, 10).compareTo((dateNow).substring(8, 10)) >= 0
                         ) ||
                         (
                           (obj.getDateEnd() + "").substring(0, 4).equals((dateNow).substring(0, 4)) &&
                           Integer.parseInt((obj.getDateEnd() + "").substring(5, 7)) - Integer.parseInt(dateNow.substring(5, 7)) == 1 &&
                           (obj.getDateEnd() + "").substring(8, 10).compareTo((dateNow).substring(8, 10)) <= 0
                         ) ||
                         (
                           Integer.parseInt((obj.getDateEnd() + "").substring(0, 4)) - Integer.parseInt((dateNow).substring(0, 4)) == 1 &&
                           (obj.getDateEnd() + "").substring(5, 7).equals("01") && dateNow.substring(5, 7).equals("12") &&
                           (obj.getDateEnd() + "").substring(8, 10).compareTo((dateNow).substring(8, 10)) <= 0
                         )
                       )
                    {
                      trangThai = "Sắp hết hạn";
                    } else if ((obj.getDateEnd() + "").substring(0, 7).equals(dateNow.substring(0, 7)) && (obj.getDateEnd() + "").substring(8, 10).compareTo(dateNow.substring(8, 10)) > 0) {
                      
                    } else if (tt < 0) {
                      trangThai = "Hết hạn";
                    } else {
                      trangThai = "Đang sử dụng";
                    }
                    
                    out.print(trangThai);
                  %>
                            </td>
                            
                            <td>
                                <%
                                    if (trangThai.equals("Sắp hết hạn")) {
                                    
                                %>
                                <button type="button" class='<%= obj.getId() %> <%= obj.getEmail()%> <%= obj.getTenDichVu() %> btn btn-warning' onclick="giaHan(this);">Gửi email thông báo</button>
                                
                                <%
                                }
                                %>
                            </td>
                        </tr>
                        <%
                        }    
                        %>
                    </tbody>
		</table>
                <%
                } else {
                %>
                <p>Không có đơn hàng nào</p>
                <%
                }
                %>
            </div>
            
            <form name="form" action="account-user" method="post">
              <input name="idSendMail" type="hidden" />
              <input name="emailSend" type="hidden" />
              <input name="tenGoiSend" type="hidden" />
            </form>
            
        </div>

        <br> <br>

    </div>
    
    <script type="text/javascript">
      function giaHan(obj) {
        var form = document.form;
        form.idSendMail.value = obj.className.split(" ")[0];
        form.emailSend.value = obj.className.split(" ")[1];
        form.tenGoiSend.value = obj.className.split(" ")[2];
        form.submit();
      }
    </script>
            
    </body>
</html>