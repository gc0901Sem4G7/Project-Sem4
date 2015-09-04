<%@page import="doituong.FQA"%>
<%@page import="doituong.Order"%>
<%@page import="model.admin.AdminDealerModel"%>
<%@page import="doituong.Dealer"%>
<%@page import="doituong.DichVu"%>
<%@page import="doituong.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
        <div class="container-fluid">
            <%
                List<FQA> listFQA = (List<FQA>) request.getAttribute("listFQA");
                if (listFQA.size() != 0) {
                    for (FQA fqa : listFQA) {
            %>
            <div class="row" style="margin-right: 10px;">

                <table class="table table-bordered table-hover">

                    <thead>
                        <tr>
                            <th><span class="green">Cau hoi: </span><%= fqa.getQuestion() %></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if ("".equals(fqa.getAnswer()) || "null".equals(fqa.getAnswer())) { %>
                            <tr>
                                <td>
                                    Trang thai: <span style="color: #F60;">Pending</span>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>
                                    <a class="btn btn-primary" href="fqa?id=<%= fqa.getId() %>" role="button">Tra loi</a>
                                </td>
                            </tr>
                        <% } else { %>
                            <tr>
                                <td>
                                    Noi dung tra loi: <%= fqa.getAnswer() %>
                                </td>
                            </tr>
                        <% } %>
                        
                    </tbody>


                </table>
            </div>
                <% } %>
            <% } else {
                out.print("Không co cau hoi nao");
               }
            %>

            
        </div>

        <br> <br>

    </div>
    
    </body>
</html>