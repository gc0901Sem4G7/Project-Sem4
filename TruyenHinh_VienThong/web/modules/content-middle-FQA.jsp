<%@page import="doituong.FQA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <th><span class="green">Câu hỏi: </span><%= fqa.getQuestion() %></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            Quản trị trả lời: 
                            <%
                            if ("".equals(fqa.getAnswer()) || "null".equals(fqa.getAnswer())) {
                                out.print("<span style='color: #F60'>Chờ trả lời</span>");
                            } else {
                                out.print(fqa.getAnswer());
                            }
                            %>
                        </td>
                    </tr>
                </tbody>
                
                
            </table>
        </div>
            <% } %>
        <% } else {
            out.print("Không co cau hoi nao");
           }
        %>
        
        <form action="fqa" method="get" role="form" style="margin-right: 10px;">
            <legend>Bạn hãy nhập câu hỏi ở đây</legend>
            <p style="color: #F60;">User cần đăng nhập trước khi đặt câu hỏi</p>
            <%
                String message = request.getAttribute("message") + "";
                if (!"".equals(message) && !"null".equals(message)) {
            %>
            <p style="color: #F00;"><%= message %></p>
            <%
                }
            %>
            <div class="form-group">
                <label for="" class="green">Nội dung</label><br><br>
                <textarea rows="5" cols="30" name="cauHoi"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Gửi</button>
        </form>
    </div>

    <br> <br>

</div>
