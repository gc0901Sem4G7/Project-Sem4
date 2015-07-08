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
                        <li>
                            Chào mừng 
                            <%
                                String username = request.getSession().getAttribute("username") + "";
                                String mien = request.getSession().getAttribute("mien") + "";
                                if (!"admin".equals(mien)) mien = "Dealer mien " + mien;
                                else mien = "Admin";
                                if (!"".equals(username) && !"null".equals(username)) {
                                    out.print(username + " (" + mien + ")");
                                }
                            %>
                        </li>
                        <li><a href="cacGoiDichVu">Các gói dịch vụ</a></li>
                        <li><a href="#">Account</a></li>
                        <li><a href="#">Góp ý</a></li>
                        <li><a href="fqa">FQA</a></li>
                        <li><a href="lienHe">Lien he</a></li>
                    </ul>
                </div>
