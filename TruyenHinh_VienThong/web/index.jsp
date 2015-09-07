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

        <%
            String url = request.getRequestURL().toString();
            String tenMenu = request.getAttribute("tenMenu") + "";
        %>

        <div class="wrapper">
            <div class="body">
                <jsp:include page="modules/banner.jsp" />
                <br>

                <jsp:include page="modules/menu.jsp" />
                <br><br>

                <div class="content" id="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" style="padding: 5px;">
                                    <img class="img-responsive" src="img/content-left.jpg" alt="">
                                </div>

                                <%
                                    if (url.endsWith("Truyen_Hinh_Vien_Thong") || url.endsWith("Truyen_Hinh_Vien_Thong/")) {
                                %>
                                <jsp:include page="modules/content-middle-trang-chu.jsp" />
                                <%
                                } else if (tenMenu.equals("Cac goi dich vu")) {
                                %>
                                <jsp:include page="modules/content-middle-cac-goi-dich-vu.jsp" />
                                <%
                                } else if (tenMenu.equals("FQA")) {
                                %>
                                <jsp:include page="modules/content-middle-FQA.jsp" />
                                <%
                                } else if (tenMenu.equals("Lien he")) {
                                %>
                                <jsp:include page="modules/content-middle-lien-he.jsp" />
                                <%
                                } else if (tenMenu.equals("register")) {
                                %>
                                <jsp:include page="modules/content-middle-register.jsp" />
                                <%
                                } else if (tenMenu.endsWith("Tai khoan")) {
                                %>
                                <jsp:include page="modules/content-middle-tai-khoan.jsp" />
                                <%
                                } else if (url.endsWith("index.jsp")) {
                                %>
                                <jsp:include page="modules/content-middle-trang-chu.jsp" />
                                <%
                                  }
                                %>

                            </div>


                            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3" id="form-dang-ky">

                                <div class="panel panel-default">

                                    <div class="panel-heading bg-info">

                                        <%
                                            String username = request.getSession().getAttribute("username") + "";
                                            if (!"".equals(username) && !"null".equals(username)) {
                                        %>
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th> <%
                                                        String message = request.getAttribute("message") + "";
                                                        if (!message.equals("null") && !message.contains("Khi") && !message.contains("đăng")) {
                                                            out.print(message);
                                                        }
                                                        %>

                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Chào mừng <a href="#"><%= username%></a></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td><a href="logout">Đăng xuất</a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                        <%
                                        } else {
                                        %>

                                        <form action="login" method="post" class="form-inline" role="form">

                                            <h3>
                                              <small style="color: red;">
                                                    <%
                                                        String message = request.getAttribute("message") + "";
                                                        if (!message.equals("null") && !message.contains("Khi")) {
                                                            out.print(message);
                                                        }
                                                    %>
                                                </small>
                                            </h3>

                                            <div class="form-group">
                                                <label for="username"><span class="infomation">Tên Đăng nhập:</span></label>
                                                <input type="text" class="form-control" name="username" id="username" placeholder="Điền tên đăng nhập">
                                            </div>

                                            <div class="form-group" style="margin-bottom: 10px;">
                                                <label for="password"><span class="infomation">Mật khẩu:</span></label>
                                                <input type="password" class="form-control" name="password" id="password" placeholder="Điền mật khẩu">
                                            </div>
                                            <br>

                                            <br>

                                            <div class="checkbox" style="margin-bottom: 10px;">
                                                <label><a href="register"> Đăng kí</a></label>
                                            </div>

                                            <br>
                                            <button type="submit" class="btn btn-warning" style="width: 100%;">Đăng nhập</button>
                                        </form>
                                        <%
                                            }
                                        %>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>

                <jsp:include page="modules/footer.jsp" />

            </div>
        </div>

        <script src="//code.jquery.com/jquery.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <script src="js/script.js"></script>
    </body>
</html>