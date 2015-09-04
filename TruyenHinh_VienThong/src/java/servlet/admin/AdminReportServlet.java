package servlet.admin;

import doituong.Dealer;
import doituong.OrderByTrangThai;
import doituong.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderModel;
import model.UserModel;
import model.admin.AdminDealerModel;

public class AdminReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String trangThai = request.getParameter("trangThaiLoc");;
        String thoiGian = request.getParameter("thoiGianLoc");;
        
        
        OrderModel orderModel = new OrderModel();
        List<OrderByTrangThai> listOrderByTrangThai = new ArrayList<OrderByTrangThai>();
        
        String mien = request.getSession().getAttribute("mien") + "";
        
        listOrderByTrangThai = orderModel.getAllOrderByMien(mien, trangThai, thoiGian);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        request.setAttribute("listOrderByTrangThai", listOrderByTrangThai);
        request.setAttribute("request", "account-report");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
