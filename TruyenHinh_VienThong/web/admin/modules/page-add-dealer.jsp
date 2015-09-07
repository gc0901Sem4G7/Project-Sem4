<%@page import="doituong.Dealer"%>
<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="content-right"  class="content" style="padding: 20px;">
    <div class="container-fluid">
        <div class="row">

            <form action="doAddAccountAdmin" method="POST" role="form">

                <legend class="green">Thêm tài khoản Dealer</legend>
                
                <div class="form-group">
                    <label for="">Tên đăng nhập</label>
                    <input type="text" class="form-control" name="username" value='' placeholder="Nhập Tên đăng nhập">
                </div>

                <div class="form-group">
                    <label for="">Mật khẩu</label>
                    <input type="password" class="form-control" name="password" value='' placeholder="Nhập Mật khẩu">
                </div>

                <div class="form-group">
                    <label for="">Họ và tên</label>
                    <input type="text" class="form-control" name="name" value='' placeholder="Nhập Họ và tên">
                </div>

                <div class="form-group">
                    <label for="">Giới tính</label>
                    <input type="text" class="form-control" name="sex" value='' placeholder="Nhập Giới tính">
                </div>

                <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" class="form-control" name="email" value='' placeholder="Nhập Email">
                </div>

                <div class="form-group">
                    <label for="">Số điện thoại</label>
                    <input type="text" class="form-control" name="phone" value='' placeholder="Nhập Số điện thoại">
                </div>

                <div class="form-group">
                    <label for="">Địa chỉ</label>
                    <input type="text" class="form-control" name="address" value='' placeholder="Nhập Địa chỉ">
                </div>

                <div class="form-group">
                    <label for="">Miền</label>
                    <input type="text" class="form-control" name="mien" value='' placeholder="Nhập miền">
                </div>

                <button type="submit" class="btn btn-primary">Tạo mới</button>
            </form>

        </div>
    </div>
</div>
    
    