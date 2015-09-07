<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div id="content-right"  class="content">

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

            <legend>Thêm mới dịch vụ</legend>

            <div class="form-group">
                <label for="">Tên dịch vụ</label>
                <input type="text" class="form-control" name="tenDichVu" id="" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Đơn giá /Tháng(VNĐ)</label>
                <input type="text" class="form-control" name="giaDichVu" id="" placeholder="Input field">
            </div>

            <div class="form-group">
                <label for="">Mô tả</label>
                <input type="text" class="form-control" name="moTa" id="" placeholder="Input field">
            </div>

            <button type="submit" class="btn btn-primary">Chấp nhận</button>
        </form>
		
    </div>
    