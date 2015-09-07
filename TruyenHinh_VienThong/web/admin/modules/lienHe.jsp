<%@page import="doituong.LienHe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        
        <%
            LienHe lienHeObject = (LienHe) request.getAttribute("lienHeObject");
        %>

        <div id="content-right"  class="content">
            <form action="adminEditLienHe" method="post">
                <%
                out.print("<table class='table table-bordered table-hover'>");
                out.print("<tbody>");

                    /*out.print("<tr>");
                        out.print("<td>ID</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getId() + "");
                        out.print("</td>");
                    out.print("</tr>");*/

                    out.print("<tr>");
                        out.print("<td>Địa chỉ</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getDiaChi() + "");
                        out.print("</td>");
                    out.print("</tr>");

                    out.print("<tr>");
                        out.print("<td>Điện thoại</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getDienThoai() + "");
                        out.print("</td>");
                    out.print("</tr>");

                    out.print("<tr>");
                        out.print("<td>Tên công ty</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getTenCongTy() + "");
                        out.print("</td>");
                    out.print("</tr>");

                    out.print("<tr>");
                        out.print("<td>Email</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getEmail() + "");
                        out.print("</td>");
                    out.print("</tr>");

                    out.print("<tr>");
                        out.print("<td>Skype</td>");
                        out.print("<td>");
                        out.print(lienHeObject.getSkype() + "");
                        out.print("</td>");
                    out.print("</tr>");


                out.print("</tbody>");

                out.print("</table>");
                %>
            </form>

        </div>
    </body>
</html>
