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
                    <label for="">Username</label>
                    <input type="text" class="form-control" name="username" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Password</label>
                    <input type="text" class="form-control" name="password" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Name</label>
                    <input type="text" class="form-control" name="name" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Sex</label>
                    <input type="text" class="form-control" name="sex" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" class="form-control" name="email" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Phone</label>
                    <input type="text" class="form-control" name="phone" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Address</label>
                    <input type="text" class="form-control" name="address" value='' placeholder="Input field">
                </div>

                <div class="form-group">
                    <label for="">Miền</label>
                    <input type="text" class="form-control" name="mien" value='' placeholder="Input field">
                </div>

                <button type="submit" class="btn btn-primary">Accept</button>
            </form>

        </div>
    </div>
</div>
    
    