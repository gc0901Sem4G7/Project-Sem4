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
		
    </div>
    