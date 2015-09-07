<%@page import="doituong.Dealer"%>
<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="content-right"  class="content" style="padding: 20px;">
    <div class="container-fluid">
        <div class="row">
            <%
                Dealer dealer = (Dealer) request.getAttribute("dealer");
            %>

            <form action="doEditAccountAdmin" method="POST" role="form">

                <legend class="green">Sửa tài khoản đại lý</legend>

                <div class="form-group">
                    <label for="">ID</label>
                    <input type="text" class="form-control" name="id" value='<%= dealer.getId() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Tên đăng nhập</label>
                    <input type="text" class="form-control" name="username" value='<%= dealer.getUsername() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Mật khẩu</label>
                    <input type="password" class="form-control" name="password" value='<%= dealer.getPassword() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Họ và tên</label>
                    <input type="text" class="form-control" name="name" value='<%= dealer.getName() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Giới tính</label>
                    <input type="text" class="form-control" name="sex" value='<%= dealer.getSex() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" class="form-control" name="email" value='<%= dealer.getEmail() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Điện thoại</label>
                    <input type="text" class="form-control" name="phone" value='<%= dealer.getPhone() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Địa chỉ</label>
                    <input type="text" class="form-control" name="address" value='<%= dealer.getAddress() %>' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Miền</label>
                    <input type="text" class="form-control" name="mien" value='<%= dealer.getMien() %>' placeholder="Input field">
                </div>

                <button type="submit" class="btn btn-primary">Sửa</button>
            </form>

        </div>
    </div>
</div>
    
    