<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="doituong.OrderByTrangThai"%>
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
      List<OrderByTrangThai> listOrderByTrangThai = (List<OrderByTrangThai>) request.getAttribute("listOrderByTrangThai");
      
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String dateNow = dateFormat.format(new Date());
      
      String trangThai = "";
  %>
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
    <div class="container-fluid">

      <div class="row" style="margin-right: 10px;">
        <label class="green">Danh sách khách hàng</label>
        
        <br>
        <br>
        <br>
        
        
        Lọc:
        <br>
        <br>
        <input type="checkbox" value="trangthai" onclick="clickStatus(this);" /> Trạng thái
        <br>
        
        <select id="trangThaiLoc" style="display: none;">
          <option value="">Chọn trạng thái</option>
          <option value="saphethan">Sắp hết hạn</option>
          <option value="hethan">Hết hạn</option>
          <option value="dangsudung">Đang sử dụng</option>
        </select>
        
        <br>
        <br>
        <br>
        
        <input type="checkbox" value="thoigian" onclick="clickTime(this);" /> Thời gian bắt đầu
        
        <select id="thoiGianLoc" style="display: none;">
          <option value="">Chọn tháng</option>
          <option value="01">Tháng 1</option>
          <option value="02">Tháng 2</option>
          <option value="03">Tháng 3</option>
          <option value="04">Tháng 4</option>
          <option value="05">Tháng 5</option>
          <option value="06">Tháng 6</option>
          <option value="07">Tháng 7</option>
          <option value="08">Tháng 8</option>
          <option value="09">Tháng 9</option>
          <option value="10">Tháng 10</option>
          <option value="11">Tháng 11</option>
          <option value="12">Tháng 12</option>
        </select>
        <br>
        <br>
        <br>
        
        <form action="report" method="post" name="form">
          <input type="hidden" name="trangThaiLoc" id="trangThaiLocAn" />
          <input type="hidden" name="thoiGianLoc" id="thoiGianLocAn" />
          
        </form>
        <button id='batdauloc' onclick="submitInfo();">Tìm kiếm</button>
        
        <br>
        <br>

        
        
        
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

        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>Tên đăng nhập</th>
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
            if (listOrderByTrangThai != null && listOrderByTrangThai.size()!=0) {
              for (OrderByTrangThai obj : listOrderByTrangThai) {
            %>
            <tr>
              <td><%= obj.getUsername() %></td>
              <td><%= obj.getTenDichVu() %></td>
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
            } }
            %>
          </tbody>
        </table>
          
        <form name="form2" action="account-user" method="post">
            <input name="idSendMail" type="hidden" />
            <input name="emailSend" type="hidden" />
            <input name="tenGoiSend" type="hidden" />
          </form>
      </div>
    </div>

    <br> <br>

  </div>
          <script type="text/javascript">
              function giaHan(obj) {
                var form2 = document.form2;
                form2.idSendMail.value = obj.className.split(" ")[0];
                form2.emailSend.value = obj.className.split(" ")[1];
                form2.tenGoiSend.value = obj.className.split(" ")[2];
                form2.submit();
              }
          </script>
      
  </body>
</html>