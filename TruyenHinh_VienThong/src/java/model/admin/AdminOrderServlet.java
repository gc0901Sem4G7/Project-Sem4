package servlet.admin;

import doituong.Order;
import doituong.OrderByTenDichVu;
import doituong.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OrderModel;
import model.UserModel;

public class AdminOrderServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    
    String username = request.getParameter("username");
    String tenDichVu = request.getParameter("tenDichVu");
    
    String trangThai = request.getParameter("trangThaiLoc");;
    String thoiGian = request.getParameter("thoiGianLoc");;
    
    OrderModel orderModel = new OrderModel();
    UserModel userModel = new UserModel();
    
    List<Order> listOrder = new ArrayList<Order>();
    
    HttpSession session = request.getSession();
    String mien = session.getAttribute("mien") + "";
    
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
    
    if (username != null) {
      listOrder = orderModel.getListOrderByUsername("order", username);
      request.setAttribute("request", "adminOrderDetail");
      request.setAttribute("listOrder", listOrder);
      
      User user = userModel.getUserByUsername("order", username);
      request.setAttribute("user", user);
      
//      User user = userModel.getAllListUser();
      request.setAttribute("tenKhachHang", listOrder);
      requestDispatcher.forward(request, response);
      return;
    } else if (tenDichVu != null) {
      request.setAttribute("request", "adminOrderDetail");
      request.setAttribute("tenDichVu", tenDichVu);
      
      List<OrderByTenDichVu> listOrderByTenDichVu = new ArrayList<OrderByTenDichVu>();
      listOrderByTenDichVu = orderModel.getListOrderByTenDichVu(tenDichVu);
      
      request.setAttribute("listOrderByTenDichVu", listOrderByTenDichVu);
      requestDispatcher.forward(request, response);
      return;
    } else {
      listOrder = orderModel.getAllOrderByMien("order", mien, trangThai, thoiGian);
      
      request.setAttribute("trangThai", trangThai);
      request.setAttribute("thoiGian", thoiGian);
    }
    
    request.setAttribute("request", "adminOrder");
    request.setAttribute("listOrder", listOrder);

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
