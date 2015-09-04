<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String url = request.getRequestURL().toString();
    String tenMenu = request.getAttribute("tenMenu") + "";
%>
<div class="menu" id="menu">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-pills">
                    <li class="<% if (!tenMenu.equals("Cac goi dich vu") && !tenMenu.equals("Gop y") && !tenMenu.equals("FQA") && !tenMenu.equals("Lien he") && !tenMenu.equals("Tai khoan")) out.print("active"); %>"><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Trang chủ</a></li>

                    <li class="<% if (tenMenu.equals("Cac goi dich vu")) out.print("active") ; %>"><a href="cacGoiDichVu"><span class="glyphicon glyphicon-film"></span> Các gói dich vụ</a></li>
                    <li class="<% if (tenMenu.equals("FQA")) out.print("active") ; %>"><a href="fqa"><span class="glyphicon glyphicon-question-sign"></span> FQA</a></li>
                    <li class="<% if (tenMenu.equals("Lien he")) out.print("active") ; %>"><a href="lienhe"><span class="glyphicon glyphicon-envelope"></span> Liên hệ</a></li>
                    <li class="<% if (tenMenu.equals("Tai khoan")) out.print("active") ; %>"><a href="taikhoan"><span class="glyphicon glyphicon-film"></span> Tài khoản</a></li>
                </ul>
            </div>

        </div>
    </div>
</div>
