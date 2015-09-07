<%@page import="doituong.LienHe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Edit Lien He</title>
        <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />
    </head>
    <body>

        <%
            LienHe lienHeObject = (LienHe) request.getAttribute("lienHeObject");
            
            if (lienHeObject != null) {
        %>

        <div id="content-right"  class="content">
            <form action="adminDoEditLienHe" method="POST" role="form">
                <legend>Edit thong tin lien he</legend>

                <div class="form-group">
                    <label for="">Dia chi</label>
                    <input type="text" class="form-control" value="<%= lienHeObject.getDiaChi() %>" name="diaChi" placeholder="Input field">
                </div>
                
                <div class="form-group">
                    <label for="">Dien thoai</label>
                    <input type="text" class="form-control" value="<%= lienHeObject.getDienThoai() %>" name="dienThoai" placeholder="Input field">
                </div>
                
                <div class="form-group">
                    <label for="">Ten cong ty</label>
                    <input type="text" class="form-control" value="<%= lienHeObject.getTenCongTy() %>" name="tenCongTy" placeholder="Input field">
                </div>
                
                <div class="form-group">
                    <label for="">Email</label>
                    <input type="text" class="form-control" value="<%= lienHeObject.getEmail() %>" name="email" placeholder="Input field">
                </div>
                
                <div class="form-group">
                    <label for="">Skype</label>
                    <input type="text" class="form-control" value="<%= lienHeObject.getSkype() %>" name="skype" placeholder="Input field">
                </div>
                
                <input type="hidden" name="id" value="<%= lienHeObject.getId() %>" />
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
        <% } %>
    </body>
</html>
