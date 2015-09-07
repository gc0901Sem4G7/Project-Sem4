package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DichVuModel;
import doituong.DichVu;
import doituong.Order;
import doituong.OrderByTenDichVu;
import doituong.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import model.OrderModel;
import model.UserModel;

public class TaiKhoanServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public TaiKhoanServlet() {
      super();
  }

  protected void doTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    OrderModel orderModel = new OrderModel();
    UserModel userModel = new UserModel();
    
    int idGiaHan = 0;
    int thoiLuongGiaHan = 0;
    String giaTienGiaHan = "";
    
    String usernameDetail = request.getParameter("usernameDetail");
    String tenDichVuDetail = request.getParameter("tenDichVuDetail");
    
    try {
      idGiaHan = Integer.parseInt(request.getParameter("idGiaHan"));
      thoiLuongGiaHan = Integer.parseInt(request.getParameter("thoiLuongGiaHan"));
      giaTienGiaHan = request.getParameter("giaTien");
    } catch (Exception ex) {
      
    }
    
    if (usernameDetail != null) {
      List<Order> listOrder = new ArrayList<Order>();
      listOrder = orderModel.getListOrderByUsername("order", usernameDetail);
      request.setAttribute("request", "adminOrderDetail");
      request.setAttribute("listOrder", listOrder);
      
      User user = userModel.getUserByUsername("order", usernameDetail);
      request.setAttribute("user", user);
      
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://localhost:8080/Truyen_Hinh_Vien_Thong/admin/order");
//      User user = userModel.getAllListUser();
      request.setAttribute("tenKhachHang", listOrder);
      requestDispatcher.forward(request, response);
      return;
    } else if (tenDichVuDetail != null) {
      request.setAttribute("request", "adminOrderDetail");
      request.setAttribute("tenDichVu", tenDichVuDetail);
      
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("http://localhost:8080/Truyen_Hinh_Vien_Thong/admin/order");
      List<OrderByTenDichVu> listOrderByTenDichVu = new ArrayList<OrderByTenDichVu>();
      listOrderByTenDichVu = orderModel.getListOrderByTenDichVu(tenDichVuDetail);
      
      request.setAttribute("listOrderByTenDichVu", listOrderByTenDichVu);
      requestDispatcher.forward(request, response);
      return;
    }
    
    if (thoiLuongGiaHan != 0) {
      Order order = new Order();
      order = orderModel.getOrderById("order", idGiaHan);
      
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      String date = order.getDateEnd() + "";
      String dateEnd = dateFormat.format(new Date());

      if ((thoiLuongGiaHan + "").equals("3") && Integer.parseInt(date.substring(5, 7)) <= 9) {
        dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 3) + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) <= 6) {
        dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 6) + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) <= 3) {
        dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 9) + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("12") && Integer.parseInt(date.substring(5, 7)) <= 12) {
        dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 12) + date.substring(7);
      }

      if ((thoiLuongGiaHan + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 10) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 11) {
        
        if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
          dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
        } else {
          dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + date.substring(7);
        }
      } else if ((thoiLuongGiaHan + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 12) {
        dateEnd = Integer.parseInt(date.substring(0, 5)) + 1 + "/03" + date.substring(7);
      }

      if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 7) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + Integer.parseInt(date.substring(7));
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 8) {
        if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
          dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
        } else {
          dateEnd = (Integer.parseInt(date.substring(0, 4)) + 1) + "/02" + date.substring(7);
        }
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 9) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/03" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 10) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/04" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 11) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/05" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 12) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/06" + date.substring(7);
      }

      if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 4) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 5) {
        if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
          dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
        } else {
          dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + date.substring(7);
        }
      
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 6) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/03" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 7) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/04" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 8) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/05" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 9) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/06" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 10) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/07" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 11) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/08" + date.substring(7);
      } else if ((thoiLuongGiaHan + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 12) {
      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/09" + date.substring(7);
      }

      if ((thoiLuongGiaHan + "").equals("12")) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "" + date.substring(4);
      }
      if ((thoiLuongGiaHan + "").equals("24")) {
        dateEnd = Integer.parseInt(date.substring(0, 4)) + 2 + "" + date.substring(4);
      }
      
      order.setId(idGiaHan);
      
      orderModel.update(order, "order", date, dateEnd);
    }
    
    HttpSession httpSession = request.getSession();
    String username = httpSession.getAttribute("username") + "";
    
    User user = userModel.getUserByUsername("user", username);
        
    List<Order> listOrder = orderModel.getListOrderByUsername("order", username);
    request.setAttribute("listOrder", listOrder);
                        
    request.setAttribute("tenMenu", "Tai khoan");
    request.setAttribute("user", user);
    RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("index.jsp");
    requestDispatcher1.forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doTask(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doTask(request, response);
  }

}
