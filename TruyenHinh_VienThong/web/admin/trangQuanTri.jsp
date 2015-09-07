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
    
<% } else if (urlRequest.equals("account-type")) { %>

    <jsp:include page="modules/admin-account-type.jsp" />

<% } else if (urlRequest.equals("account-type-user")) { %>

    <jsp:include page="modules/admin-account-user.jsp" />

<% } else if (urlRequest.equals("account-type-admin")) { %>

    <jsp:include page="modules/admin-account-admin.jsp" />
    
<% } else if (urlRequest.equals("admin account admin edit")) { %>

    <jsp:include page="modules/admin-account-admin-edit.jsp" />
    
<% } else if (urlRequest.equals("pageAddDealer")) { %>

    <jsp:include page="modules/page-add-dealer.jsp" />
    
<% } else if (urlRequest.equals("adminOrder")) { %>

    <jsp:include page="modules/adminOrder.jsp" />

<% } else if (urlRequest.equals("adminOrderDetail")) { %>

    <jsp:include page="modules/adminOrderDetail.jsp" />
        
<% } else if (urlRequest.equals("cacGoiDichVu")) { %>
    
    <jsp:include page="modules/adminDichVu.jsp" />
    
<% } else if (urlRequest.equals("adminThemMoiDichVu")) { %>
    
    <jsp:include page="modules/adminThemMoiDichVu.jsp" />
    
<% } else if (urlRequest.equals("FQAReply")) { %>
    
    <jsp:include page="modules/adminReply.jsp" />
    
<% } else if (urlRequest.equals("FQA")) { %>
    
    <jsp:include page="modules/adminFQA.jsp" />
    
<% } else if (urlRequest.equals("account-report")) { %>
    
    <jsp:include page="modules/admin-report.jsp" />

<% } %>

<%@ include file="modules/admin-footer.jsp" %>