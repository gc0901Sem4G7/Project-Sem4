<%@page import="doituong.DichVu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="js/script.js"></script>
<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
    <div class="container-fluid">
        <div class="row">
            <form action="register" method="POST" role="form" style="width: 80%; margin: auto;">
                <legend>Mẫu Đăng Ký</legend>

                <%
                    String message = request.getAttribute("message") + "";
                    if (!"".equals(message) && !"null".equals(message)) {
                %>
                    <br>
                    <p style="color: red;"><%= message %></p>
                    <br>
                <% } %>
                
                <div class="form-group">
                    <label for="username">Tên đăng nhập:</label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Điền tên đăng nhập">
                </div>

                <div class="form-group">
                    <label for="password">Mật khẩu:</label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Điền mật khẩu">
                </div>

                <div class="form-group">
                    <label for="name">Họ và tên:</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="Điền họ và tên">
                </div>

                <div class="form-group">
                    <label for="card_id">Chứng minh thư:</label>
                    <input type="text" class="form-control" name="card_id" id="card_id" placeholder="Điền Chứng minh thư">
                </div>

                <div class="form-group">
                    <label for="phone_number">Số điện thoại:</label>
                    <input type="text" class="form-control" name="phone_number" id="phone_number" placeholder="Điền Số điện thoại">
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" name="email" id="email" placeholder="Điền Email">
                </div>

                <div class="form-group">
                    <label for="address">Địa chỉ</label>
                    <input type="text" class="form-control" name="address" id="address" placeholder="Điền Địa chỉ">
                </div>
                <div class="form-group">
                    <label for="address">Miền:</label>
                    
                    <select name="mien">
                      <option>Mien Bac</option>
                      <option>Mien Trung</option>
                      <option>Mien Nam</option>
                    </select>
                </div>

                <button type="submit" id="btn-dang-ky" class="btn btn-primary">Đăng ký</button>
            </form>
        </div>

        <br>
    </div>

    <br> <br>

</div>
