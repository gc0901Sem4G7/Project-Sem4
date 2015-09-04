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
  <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9" style="margin-top: 20px;">
        <div class="container-fluid">
            <%
              FQA fqa = (FQA) request.getAttribute("fqaObject");
                if (fqa != null) {
            %>
            <div class="row" style="margin-right: 10px;">

                <table class="table table-bordered table-hover">

                    <thead>
                        <tr>
                            <th><span class="green">Cau hoi: </span><%= fqa.getQuestion() %></th>
                        </tr>
                    </thead>
                    <tbody>
                          <tr>
                              <td>
                                <form action="fqa" method="post">
                                  <input type="hidden" class="form-control" name="id" value='<%= fqa.getId() %>' pattern="" title="">
                                
                                  <textarea name="answer" rows="4" cols="40">

                                  </textarea>
                                
                                  <br>
                                  <br>
                                  
                                  <input type="submit" class="form-control" value="Submit" pattern="" title="" style="width: 100px;">
                              </td>
                          </tr>
                    </tbody>


                </table>
            </div>
                        
                <% } %>

            
        </div>

        <br> <br>

    </div>
    
    </body>
</html>