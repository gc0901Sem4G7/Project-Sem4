<%@page import="doituong.DichVu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="modules/admin-header-content-left.jsp" %>

<%
    String urlRequest = request.getAttribute("request") + "";
    if (urlRequest.equals("lienHe")) {
%>

    <jsp:include page="modules/lienHe.jsp" />
    
<% } else if (urlRequest.equals("adminEditLienHe")) { %>
    
    <jsp:include page="modules/adminEditLienHe.jsp" />
        
<% } else if (urlRequest.equals("cacGoiDichVu")) { %>
    
    <jsp:include page="modules/adminDichVu.jsp" />
    
<% } else if (urlRequest.equals("adminThemMoiDichVu")) { %>
    
    <jsp:include page="modules/adminThemMoiDichVu.jsp" />
    
<% } %>

<%@ include file="modules/admin-footer.jsp" %>