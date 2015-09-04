<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="doituong.User"%>
<%@page import="doituong.Order"%>
<%@page import="doituong.DichVu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  String dateNow = dateFormat.format(new Date());
  String trangThai = "";
  
%>

<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
  <div class="container-fluid">
    
    <div class="row">
      <h1 class="green">Thông tin cá nhân</h1>
      
      <table class="table table-condensed table-hover">
            <thead>
              <tr>
                <th>Username</th>
                <th>Họ tên</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
              </tr>
            </thead>

            <tbody>
              <%
                User user = (User) request.getAttribute("user");
                if (user != null) {
              %>
              <tr>
                <td><%= user.getUsername() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getPhoneNumber() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getAddress() %></td>
                
              </tr>
              <%
                } else {
                  out.print("<p>Không có</p>");
                }
              %>
            </tbody>
          </table>
            
    </div>
    
      <div class="row">
          <h1 class="green">Các gói quý khách đã đăng ký</h1>
<%
String msg = request.getAttribute("msg") + "";
if (!"".endsWith(msg) && !"null".endsWith(msg)) {
  out.print("<p style='color: red;'>" + msg + "</p>");
}
%>
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>Tên Dịch Vụ</th>
                <th>Giá tiền/Tháng</th>
                <th style="width: 60px;">Thời lượng</th>
                <th>Thành tiền</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Trang thái</th>
              </tr>
            </thead>

            <tbody>
              <%

                List<Order> listOrder = (List<Order>) request.getAttribute("listOrder");

                if (listOrder != null) {
                    if (listOrder.size() != 0) {

                for(Order obj : listOrder) {
              %>
              <tr>
                <td><%= obj.getTenDichVu() %></td>
                <td><%= obj.getGia() %></td>
                <td><%= obj.getThoiLuong() %></td>
                <td><%= Integer.parseInt(obj.getGia()) * obj.getThoiLuong() %></td>
                <td><%= obj.getDateRegister() %></td>
                <td><%= obj.getDateEnd() %></td>
                <td>
                  <%
                  
                    int tt = (obj.getDateEnd() + "").compareTo(dateNow + "");
                    
                    if ((obj.getDateEnd() + "").substring(0, 4).equals((dateNow).substring(0, 4)) &&
                        (obj.getDateEnd() + "").substring(8, 10).compareTo((dateNow).substring(8, 10)) <= 0 &&
                         Integer.parseInt((obj.getDateEnd() + "").substring(5, 7)) - Integer.parseInt(dateNow.substring(5, 7)) == 1)
                    {
                      trangThai = "Sắp hết hạn";
                    } else if ((obj.getDateEnd() + "").substring(0, 7).equals(dateNow.substring(0, 7)) && (obj.getDateEnd() + "").substring(8, 10).compareTo(dateNow.substring(8, 10)) > 0) {
                      
                    } else if ( (obj.getDateEnd() + "").compareTo(dateNow + "") < 0 ) {
                      trangThai = "Hết hạn";
                    } else {
                      trangThai = "Đang sử dụng";
                    }
                    
                    out.print(trangThai);
                  %>
                </td>
                
                <% if (trangThai.equals("Sắp hết hạn") || trangThai.equals("Đang sử dụng")) { %>
                <td><button class="btn btn-primary gia-han <%= obj.getId() %> <%= obj.getTenDichVu() %> <%= obj.getGia()%>" onclick="javascript:clickGiaHan(this);">Gia hạn</button></td>
                <% } else { %>
                  <td></td>
                <% } %>
              </tr>
              <%
                }
                  } else {
                      out.print("<p>Chưa có gói nào được đăng ký hoặc đã bị hủy đăng ký</p>");
                  }
                } else {
                  out.print("<p>Chưa có gói nào được đăng ký hoặc đã bị hủy đăng ký</p>");
                }
              %>
            </tbody>
          </table>
            
            
      </div>
            
      <div id="popup1" onclick="javascript:closePopup();" style="width: 100%; height: 100%; background: #000; opacity: 0.3; position: fixed; top: 0; left: 0; display: none;">
        
      </div>
      <div id="popup2" class="container" style="width: 40%; border: 1px solid #CCC; background: #FFF; position: fixed; top: 30%; left: 30%; display: none;">
        <h2>Điền thông tin gia hạn</h2>
        <form role="form" name="form" action="taikhoan">
          <div class="form-group">
            <label for="usr">Tên dịch vụ</label>
            <input type="tenDichVu" class="form-control" id="tenDichVuGiaHan" value="">
          </div>
          <div class="form-group">
            <label for="pwd">Thời lượng</label>
            <br>
            <br>
            
            <input type="radio" name="thoiLuong" onclick="javascript:chooseThoiLuong(this);" value="3">3 Tháng<br>
            <input type="radio" name="thoiLuong" onclick="javascript:chooseThoiLuong(this);" value="6">6 Tháng<br>
            <input type="radio" name="thoiLuong" onclick="javascript:chooseThoiLuong(this);" value="12">12 Tháng<br>
            <input type="radio" name="thoiLuong" onclick="javascript:chooseThoiLuong(this);" value="24">24 Tháng<br>
          </div>
          
          <div class="form-group">
            <label for="usr">Thành tiền</label>
            <input type="text" class="form-control" id="thanhTienGiaHan">
          </div>
          
          <input name="thoiLuongGiaHan" type="text" value="" />
          <input name="giaTien" type="text" value="" />
          <input name="idGiaHan" type="text" value="" />
          
          <div class="form-group">
            <label for="usr"></label>
            <button type="submit" class="btn btn-primary" id="btnGiaHan" name="btnGiaHan">Submit</button>
          </div>
        </form>
      </div>
     </div>

  <br> <br>
  <script type="text/javascript">
    var endClass;
    function clickGiaHan(obj) {
      document.getElementById('popup1').style.display = "block";
      document.getElementById('popup2').style.display = "block";
      var previousClass = obj.className.split(" ")[0] + " " + obj.className.split(" ")[1] + " " + obj.className.split(" ")[2] + " " + obj.className.split(" ")[3];
      
      endClass = obj.className.split(" ")[obj.className.split(" ").length - 1];
      var index = obj.className.indexOf(endClass);
      var tenGoiGiaHan= obj.className.substring(previousClass.length, index);
      document.getElementById('tenDichVuGiaHan').value = tenGoiGiaHan;
      document.form.idGiaHan.value = obj.className.split(" ")[3];
      
      
    }
    function giaHan(obj) {
      var className = obj.className;
      var id = className.split(" ")[3];
      var form = document.form;
      form.idGiaHan = id;
      form.submit();
    }
    
    function closePopup() {
      document.getElementById('popup1').style.display = "none";
      document.getElementById('popup2').style.display = "none";
    }
    
    function chooseThoiLuong(obj) {
      document.getElementById('thanhTienGiaHan').value = obj.value * endClass;
      var form = document.form;
      form.thoiLuongGiaHan.value = obj.value;
      form.giaTien.value = endClass;
      
      
      
    }
    
    function clickBtnGiaHan() {
      var form = ducument.form;
      form.btnGiaHan.submit();
    }
  </script>

</div>
