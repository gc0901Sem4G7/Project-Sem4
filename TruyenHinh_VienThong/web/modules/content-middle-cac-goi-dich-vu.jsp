<%@page import="doituong.Order"%>
<%@page import="doituong.DichVu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
    <div class="container-fluid">
        <div class="row">
            <h1 class="green">Đăng ký mới gói dịch vụ</h1>
            <%
                String vung = request.getParameter("vung") + "";
            %>
            
            <br>
            <h4>Quý khánh vui lòng làm theo các bước</h4>
            <br>
            
            Bước 1<br>
            Chọn vùng miền:
            <p id="chonVungMien"></p>
            <select name="" id="mienDat" class="form-control" required="required" style="width: 50%;" onchange="getValueMienDatToIdMienDatAn();">
                <option value="">Lựa chọn vùng miền...</option>
                <option value="bac" <% if (vung.equals("bac")) {out.print("selected='selected'");} %>>Miền Bắc</option>
                <option value="trung" <% if (vung.equals("trung")) {out.print("selected='selected'");} %>>Miền Trung</option>
                <option value="nam" <% if (vung.equals("nam")) {out.print("selected='selected'");} %>>Miền Nam</option>
            </select>
            <br>
            
            Bước 2<br>
            Điền địa chỉ lắp đặt:
            <p id="diaChiNapDatMessage"></p>
            <input type="text" name="" id="diaChiNapDat" class="form-control" onkeyup="getValueDiaChiNapDatToDiaChiNapDatAn();" placeholder="Nhập địa chỉ..." style="width: 50%;" />
            <br>
            <br>
            
            Bước 3<br>
            Chọn thời lượng gói:
            <p id="chonThoiLuongGoi"></p>
            <select name="" id="thoiLuongGoi" class="form-control" required="required" style="width: 50%;" onchange="getValueThoiLuongGoiToIdThoiLuongGoiAn();" on>
                <option value="">Chọn gói thời gian đăng ký...</option>
                <option value="3">3 tháng</option>
                <option value="6">6 tháng</option>
                <option value="12">12 tháng</option>
                <option value="24">24 tháng</option>
            </select>
            <br>
            <br>
            
            Bước 4<br>
            Phương thức thanh toán:
            <p id="phuongThucThanhToan"></p>
            
            <div class="form-group">
              <!--<label for="sel1">Mời chọn: </label><-->
              <select class="form-control" onchange="getValueHinhThucThanhToanToHinhThucThanhToanAn();" id="hinhThucThanhToan">
                <option selected="" value="chua chon">Chọn môt hình thức</option>
                <option value="Tai nha">1. Tại nhà</option>
                <option value="Truc tiep tai van phong cong ty">2. Trực tiếp tại văn phòng công ty</option>
                <option value="Chuyen khoan ngan hang VCB. STK: 123456789123, Ten chu khoan: Nguyen Van A">3. Chuyển khoản ngân hàng </option>
              </select>
            </div>
            
            
            <br>
            <br>
            
            <p id="noiThanhToan" style="color: red"></p>
            
            <form action="dangKyGoiDichVu" method="get" role="form" id="mienDatForm">
                <input type="hidden" id="mienDatAn" name="vung">
                <input type="hidden" id="diaChiNapDatAn" name="diaChiNapDat">
                <input type="hidden" id="thoiLuongGoiAn" name="thoiLuong">
                <input type="hidden" id="hinhThucThanhToanAn" name="hinhThucThanhToan">
                <input type="hidden" id="idAn" name="id" value="">
                <input type="hidden" id="msgAn" name="msg" value="">
            </form>
            
            <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <!--<th>Id</th>-->
                        <th>Tên Dịch Vụ</th>
                        <th>Đơn Giá/ tháng(VNĐ)</th>
                        <th>Mô tả</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                  <%
                
                  String message = request.getAttribute("message") + "";
                  if (!"null".equals(message) && !"".equals(message) ) {
                      out.print("<p style='color: green'>" + message + "<p>");
                  }

                  List<DichVu> listDichVuAccepted = (List<DichVu>) request.getAttribute("listDichVuAccepted");
                  if (listDichVuAccepted != null) {
                      if (listDichVuAccepted.size() != 0) {
                  int i = 0;
                  for(DichVu obj : listDichVuAccepted) {
                    
                  %>
                  <tr>
                    <!--<td><%= obj.getId()%></td><-->
                    <td><%= obj.getTenDichVu()%></td>
                    <td class="giaTien<%= i %>"><%= obj.getGiaDichVu()%></td>
                    <td><%= obj.getMoTa() %></td>
                    <td><button type="button" class='giaTien<%= i %> btn btn-primary dang-ky-<%= obj.getId() %>' onclick="return validate(this);">Đăng ký</button></td>
                  </tr>
                  <%
                    i++;
                    } } }
                  %>
                </tbody>
            </table>

            

        </div>

        <br>
        
        
    </div>

    <br> <br>

</div>
            
<script language="javascript">
  function getValueMienDatToIdMienDatAn() {
    var mienDat = document.getElementById("mienDat");
    var valueMienDat = mienDat.options[mienDat.selectedIndex].value;
    document.getElementById("mienDatAn").value = valueMienDat;
  }

  function getValueThoiLuongGoiToIdThoiLuongGoiAn() {
    var thoiLuongGoi = document.getElementById("thoiLuongGoi");
    var valueThoiLuongGoi = thoiLuongGoi.options[thoiLuongGoi.selectedIndex].value;
    document.getElementById("thoiLuongGoiAn").value = valueThoiLuongGoi;
  }

  function getValueDiaChiNapDatToDiaChiNapDatAn() {
    var diaChiNapDat = document.getElementById("diaChiNapDat");
    document.getElementById("diaChiNapDatAn").value = diaChiNapDat.value;
  }
  
  function getValueHinhThucThanhToanToHinhThucThanhToanAn() {
    var e = document.getElementById("hinhThucThanhToan");
    var hinhthucthanhtoan = e.options[e.selectedIndex].value;
    document.getElementById("hinhThucThanhToanAn").value = hinhthucthanhtoan;
    if (hinhthucthanhtoan == "Tai nha") {
      document.getElementById("noiThanhToan").innerHTML = "Bạn chọn thanh toán tại địa chỉ nhà bạn.";
    } else if (hinhthucthanhtoan == "Truc tiep tai van phong cong ty") {
      document.getElementById("noiThanhToan").innerHTML = "Bạn chọn thanh toán tại công ty. Địa chỉ công ty chúng tôi là Tòa nhà Detech, số 8 Tôn Thất Thuyết, phường Mỹ Đình 2, quận Nam Từ Liêm, TP.Hà Nội. Vui lòng thanh toán tại đây";
    } else if (hinhthucthanhtoan == "Chuyen khoan ngan hang VCB. STK: 123456789123, Ten chu khoan: Nguyen Van A") {
      document.getElementById("noiThanhToan").innerHTML = "Bạn chọn thanh toán theo chuyển khoản. Vui lòng thanh toán theo thông tin sau. Ngân hàng Thương mại cổ phần Ngoại thương Việt Nam – Sở giao dịch 198 Trần Quang Khải. Số Tài khoản: 0011001803620. Tên Chủ tài khoản: Công ty dịch vụ truyền thông DTH";
    }
  }

  function validate(obj) {
    var mienDatAn = document.getElementById("mienDatAn").value;
    var diaChiNapDatAn = document.getElementById("diaChiNapDatAn").value;
    var thoiLuongGoiAn = document.getElementById("thoiLuongGoiAn").value;
    var hinhThucThanhToan = document.getElementById("hinhThucThanhToanAn").value;

    var classNameThis = obj.className;
    var id = classNameThis.substring(33, classNameThis.lenght);
    document.getElementById("idAn").value = id;
    if (mienDatAn == "" || thoiLuongGoiAn == "" || diaChiNapDatAn == "" || hinhThucThanhToan == "" || hinhThucThanhToan == "chua chon") {
      alert("Bạn phải điền 4 thông tin trên");
      return false;
    } else {
      
      
      var classLayGiaTien = obj.className.split(" ")[0];

      var soThang = document.getElementsByClassName(classLayGiaTien)[0].innerHTML;

      var msg = "Ban da dang ki trong thoi gian " + thoiLuongGoiAn + "thang. Tong chi phi: " + (thoiLuongGoiAn * soThang) + " VND";
      document.getElementById('msgAn').value = msg;
      document.getElementById("mienDatForm").submit();
    }
  }
</script>
