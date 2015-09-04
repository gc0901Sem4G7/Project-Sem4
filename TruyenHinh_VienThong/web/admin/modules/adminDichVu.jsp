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
    <div id="content-right" class="content">
        <h1 class="green">Các gói dịch vụ của dealer gửi lên admin</h1>
        <p class="navbar-text">
            <a href="adminThemMoiDichVu" class="navbar-link">Them dich vu moi</a>
	</p>
        <br>
        <br>
    	<%
    	String action = request.getAttribute("action") + "";
        
        List<DichVu> listDichVu = (List<DichVu>) request.getAttribute("listDichVu");
        
        if (listDichVu != null) {
            if (listDichVu.size() != 0) {
        %>
            <div class="container-fluid">
                <div class="row">

                    <table class="table table-condensed table-hover">

                        <thead>
                            <tr>
                                <th>Ten Dich Vu</th>
                                <th>Gia Dich Vu</th>
                                <th>Mo Ta</th>
                                <th>Trang thai</th>
                                <th>Nguoi them (username)</th>
                                <th>Nguoi them (name)</th>
                                <%
                                String mien = session.getAttribute("mien") + "";
                                if (mien.equals("admin")) {
                                %>
                                <th></th>
                                <th></th>
                                <% } %>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            AdminDealerModel adminDealerModel = new AdminDealerModel();
                            for(DichVu obj : listDichVu) {
                            %>
                            
                            <tr>
                                <td><%= obj.getTenDichVu()%></td>
                                <td><%= obj.getGiaDichVu() %></td>
                                <td><%= obj.getMoTa() %></td>
                                <td><%= obj.getTrangThai() %></td>
                                <td><%= adminDealerModel.getDealerById(obj.getDealerId()).getUsername() %></td>
                                <td><%= adminDealerModel.getDealerById(obj.getDealerId()).getName()%></td>
                                <%
                                if (mien.equals("admin")) {
                                %>
                                <td><a href="cacGoiDichVu?action=accept&id=<%= obj.getId()%>"><% if(obj.getTrangThai().equals("waiting")) { out.print("accept"); } %></a></td>
                                <td><a href="cacGoiDichVu?action=denied&id=<%= obj.getId()%>"><% if(obj.getTrangThai().equals("waiting")) { out.print("denied"); } %></a></td>
                                <% } %>
                            </tr>
                            
                            <%
                            }
                            %>
                        </tbody>
                    </table>

                    

                </div>


                <br>
            </div>
        <%
            }
        } else {
            if ("action-edit".equals(action)) {
            DichVu dichVu = (DichVu) request.getAttribute("dichVu");
    	%>
    	<form action="do-edit-dich-vu" method="POST" role="form">
   	
            <legend>Edit dich vu</legend>

            <div class="form-group">
                <label for="">Ten dich vu</label>
                <input type="text" class="form-control" name="tenDichVu" value="<%= dichVu.getTenDichVu() %>" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Gia dich vu</label>
                <input type="text" class="form-control" name="giaDichVu" value="<%= dichVu.getGiaDichVu() %>" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Mo ta</label>
                <input type="text" class="form-control" name="moTa" value="<%= dichVu.getMoTa() %>" placeholder="Input field">
            </div>

            <button type="submit" class="btn btn-primary">Accept</button>
        </form>
	<% } else { %>
            <form action="do-them-moi-dich-vu" method="POST" role="form">

                <span style="color: red;">
                    <%
                    String status = request.getAttribute("status") + "";
                    if (status.equals("Insert Failure")) {
                        out.print(status);
                        out.print("<br>");
                        out.print("<br>");
                    }
                    %>
                </span>

                <legend>Them moi dich vu</legend>

                <div class="form-group">
                    <label for="">Ten dich vu</label>
                    <input type="text" class="form-control" name="tenDichVu" id="" placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Gia dich vu</label>
                    <input type="text" class="form-control" name="giaDichVu" id="" placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Mo ta</label>
                    <input type="text" class="form-control" name="moTa" id="" placeholder="Input field">
                </div>

                <button type="submit" class="btn btn-primary">Accept</button>
            </form>
        <% } %>
        <% } %>
		
        
    </div>
                
    <script type="text/javascript">
      var url      = window.location.href;
      if (url.indexOf("cacGoiDichVu?action=finish") > -1 || url.indexOf( "cacGoiDichVu?action=cancel") > -1) {
        window.location.href = "http://localhost:8080/Truyen_Hinh_Vien_Thong/admin/order";
      }

    </script>
                
    </body>
</html>