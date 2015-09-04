<%@page import="doituong.LienHe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <table class="table border-hover">
                        <thead>
                            <tr>
                                <th colspan="2">Thông tin liên hệ</th>
                            </tr>
                        </thead>

                        <tbody>
                            <%
                                LienHe lienHe = (LienHe) request.getAttribute("lienHe");
                            %>
                            <tr>
                                <td>Địa chỉ:</td>
                                <td><%= lienHe.getDiaChi() %></td>
                            </tr>

                            <tr>
                                <td>Điện thoại:</td>
                                <td><%= lienHe.getDienThoai() %></td>
                            </tr>

                            <tr>
                                <td>Tên công ty</td>
                                <td><%= lienHe.getTenCongTy() %></td>
                            </tr>

                            <tr>
                                <td>Email:</td>
                                <td><%= lienHe.getEmail() %></td>
                            </tr>

                            <tr>
                                <td>Skype:</td>
                                <td><%= lienHe.getSkype() %></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <br>

    </div>

    <br> <br>

</div>
