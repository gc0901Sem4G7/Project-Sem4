<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="doituong.Order"%>
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
      List<Order> listOrder = (List<Order>) request.getAttribute("listOrder");
  %>
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
    <div class="container-fluid">

      <div class="row" style="margin-right: 10px;">
        <label class="green">Danh sách Đặt hàng</label>
        
        <br>
        
        <form action="report" method="post" name="form">
          <input type="hidden" name="trangThaiLoc" id="trangThaiLocAn" />
          <input type="hidden" name="thoiGianLoc" id="thoiGianLocAn" />
          
        </form>
        
        
        <br>
        <br>
        
        <%
          String trangThai = request.getAttribute("trangThai") + "";
          String thoiGian = request.getAttribute("thoiGian") + "";
          Calendar now = Calendar.getInstance();
          int year = now.get(Calendar.YEAR);
          
          if (!"null".equals(trangThai) && !"".equals(trangThai)) {
            out.print("<p style='color: red'>Ban tìm kiếm với điều kiện trạng thái: " + trangThai + "<p>");
          }
          if (!"null".equals(thoiGian) && !"".equals(thoiGian)) {
            out.print("<p style='color: red'>Ban tìm kiếm thời: " + thoiGian + " năm " + year + "<p>");
          }
        %>
        
        
        
        <br>
        <br>
        <br>
        
        
        
        <script type="text/javascript">
          var trangthai = "";
          var thoigian = "";
          function clickStatus(obj) {
            var isCheck = obj.checked;
            
            if (isCheck) {
              document.getElementById("trangThaiLoc").style.display = "block";
            } else {
              document.getElementById("trangThaiLoc").style.display = "none";
            }
          }
          
          function clickTime(obj) {
            var isCheck = obj.checked;
            
            if (isCheck) {
              document.getElementById("thoiGianLoc").style.display = "block";
            } else {
              document.getElementById("thoiGianLoc").style.display = "none";
            }
          }
          
          function submitInfo() {
            var e1 = document.getElementById("trangThaiLoc");
            document.getElementById("trangThaiLocAn").value = e1.options[e1.selectedIndex].value;
            var e2 = document.getElementById("thoiGianLoc");
            document.getElementById("thoiGianLocAn").value = e2.options[e2.selectedIndex].value;
            
            var form = document.form;
            form.submit();
          }
        </script>
        
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
              <th>Hình thức thanh toán</th>
              <th>Thời lượng</th>
              <th>Giá tiền</th>
              <th>Status</th>
              <th>Date Register</th>
              <th>Date End</th>
              <th>Xác nhận</th>
              <th>Hủy</th>
            </tr>
          </thead>
          <tbody>
            <%
            for (Order obj : listOrder) {
            %>
            <tr>
              <td><a href="?username=<%= obj.getUsername()%>"><%= obj.getUsername()%></a></td>
              <td><a href="?tenDichVu=<%= obj.getTenDichVu()%>"><%= obj.getTenDichVu() %></a></td>
              <td><%= obj.getMien() %></td>
              <td><%= obj.getDiaChiNapDat() %></td>
              <td><%= obj.getHinhThucThanhToan()%></td>
              <td><%= obj.getThoiLuong() %></td>
              <td><%= obj.getGia() %></td>
              <td>
                <%
                if (obj.getHinhThucThanhToan().equals("Da chuyen khoan")) {
                %>
                Da nop
                <%
                } else {
                %>
                <%= obj.getStatus()%>
                <%
                }
                %>
              </td>
              <td><%= obj.getDateRegister() %></td>
              <td><%= obj.getDateEnd() %></td>
              <td>
                
                  <% 
                  if(obj.getStatus().equals("waiting") && !obj.getHinhThucThanhToan().equals("Chuyen khoan")) {
                  %>
                  <a href="cacGoiDichVu?action=finish&id=<%= obj.getId()%>">Xác nhận đã nộp tiền</a>
                  <%
                  } else {
                  %>
                    Đã xác nhận
                  <%
                    }
                  %>
                </a>
              </td>
              <td>
                
                  <%
                  if(obj.getStatus().equals("waiting") && !obj.getHinhThucThanhToan().equals("Chuyen khoan")) {
                  %>
                  <a href="cacGoiDichVu?action=cancel&id=<%= obj.getId()%>">Huỷ nộp tiền</a>
                  <%}
                   else {
                  %>
                    Đã xác nhận
                  <%
                  }
                  %>
                </a>
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
        <p>Không có đơn đặt hàng nào</p>
        <%
        }
        %>
      </div>
    </div>

    <br> <br>

  </div>

      
  </body>
</html>