<%@page import="doituong.DichVu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css" rel="stylesheet">
        <script src="../js/jquery.min.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                Truyền Hình Viễn Thông
            </div>

            <div id="content">
                <div id="content-left" class="content">
                    <ul>
                        <li style="background: #DEDEDE; color: #B30;">
                            Chào mừng 
                            <%
                                String admin = request.getSession().getAttribute("admin") + "";
                                String mien = request.getSession().getAttribute("mien") + "";
                                if (!"admin".equals(mien)) mien = "Dealer mien " + mien;
                                else mien = "Admin";
                                if (!"".equals(admin) && !"null".equals(admin)) {
                                    out.print(admin + "<br>(" + mien + ")");
                                    out.print("<br>");
                                    out.print("Hay chon muc can quan ly");
                                }
                                
                                out.print("<br>");
                                out.print("<a class='btn btn-info' href='logout?admin=" + admin + "' role='button'>Logout</a>");
                            %>
                        </li>
                        <li><a href="cacGoiDichVu">Các gói dịch vụ</a></li>
                        <li><a href="order">Đơn hàng</a></li>
                        <li><a href="account-type">Tài khoản</a></li>
                        <li><a href="report">Thống kê</a></li>
                        <li><a href="fqa">FQA</a></li>
                        <li><a href="lienHe">Liên hệ</a></li>
                    </ul>
                </div>
