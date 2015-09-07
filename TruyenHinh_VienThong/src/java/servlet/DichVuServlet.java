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
import doituong.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import model.OrderModel;
import model.UserModel;

public class DichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DichVuServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String bac = "bac";
        String trung = "trung";
        String nam = "nam";
        String vung = request.getParameter("vung") + "";
        
        HttpSession httpSession = request.getSession();
        String username = httpSession.getAttribute("username") + "";
        
        OrderModel orderModel = new OrderModel();
        
        DichVu dichVu;
        User user;
        
        DichVuModel dichVuModel = new DichVuModel();
        List<DichVu> listDichVuAccepted = dichVuModel.getDichVuAccepted("dich_vu");
        
        if (vung.equals(bac) || vung.equals(trung) || vung.equals(nam)) {
            listDichVuAccepted = dichVuModel.getListDichVuByVung("dich_vu", vung);
            request.setAttribute("vung", vung);
        }
        
        String dichVuId = request.getParameter("id");
        
        if (url.contains("dangKyGoiDichVu")) {
            
            if (username.equals("") || username.equals("null")) {
                request.setAttribute("message", "Ban can dang nhap truoc");
            } else {
            
                if ((vung.equals(bac) || vung.equals(trung) || vung.equals(nam)) && (dichVuId.equals("null") || dichVuId.equals(""))) {
                    listDichVuAccepted = dichVuModel.getListDichVuByVung("dich_vu", vung);
                } else {
                    String diaChiNapDat = request.getParameter("diaChiNapDat");
                    String hinhThucThanhToan = request.getParameter("hinhThucThanhToan");
                    String thoiLuongString = request.getParameter("thoiLuong");
                    int thoiLuong = Integer.parseInt(thoiLuongString);
                    String giaTien = request.getParameter("giaTien");
                    
                    String tenDichVu = dichVuModel.getDichVuById(Integer.parseInt(dichVuId), "dich_vu").getTenDichVu();
                    
                    dichVu = new DichVu();
                    dichVu = dichVuModel.getDichVuById(Integer.parseInt(dichVuId), "dich_vu");
                    user = new User();
                    UserModel userModel = new UserModel();
                    
                    user = userModel.getUserByUsername("user", username);
                    request.setAttribute("user", user);
                    
                    dichVu.setTenDichVu(tenDichVu);
                    user.setUsername(username);
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String date = dateFormat.format(new Date());
                    String dateEnd = dateFormat.format(new Date());
                    
                    if ((thoiLuong + "").equals("3") && Integer.parseInt(date.substring(5, 7)) <= 9) {
                      dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 3) + date.substring(7);
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) <= 6) {
                      dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 6) + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) <= 3) {
                      dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 9) + date.substring(7);
                    } else if ((thoiLuong + "").equals("12") && Integer.parseInt(date.substring(5, 7)) <= 12) {
                      dateEnd = date.substring(0, 5) + (Integer.parseInt(date.substring(5, 7)) + 12) + date.substring(7);
                    }

                    if ((thoiLuong + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 10) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + date.substring(7);
                    } else if ((thoiLuong + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 11) {

                      if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
                        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
                      } else {
                        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + date.substring(7);
                      }
                    } else if ((thoiLuong + "").equals("3") && Integer.parseInt(date.substring(5, 7)) == 12) {
                      dateEnd = Integer.parseInt(date.substring(0, 5)) + 1 + "/03" + date.substring(7);
                    }

                    if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 7) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + Integer.parseInt(date.substring(7));
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 8) {
                      if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
                        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
                      } else {
                        dateEnd = (Integer.parseInt(date.substring(0, 4)) + 1) + "/02" + date.substring(7);
                      }
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 9) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/03" + date.substring(7);
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 10) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/04" + date.substring(7);
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 11) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/05" + date.substring(7);
                    } else if ((thoiLuong + "").equals("6") && Integer.parseInt(date.substring(5, 7)) == 12) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/06" + date.substring(7);
                    }

                    if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 4) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/01" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 5) {
                      if (dateEnd.substring(8, 10).equals("30") || dateEnd.substring(8, 10).equals("31")) {
                        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + "/28";
                      } else {
                        dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/02" + date.substring(7);
                      }

                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 6) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/03" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 7) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/04" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 8) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/05" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 9) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/06" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 10) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/07" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 11) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/08" + date.substring(7);
                    } else if ((thoiLuong + "").equals("9") && Integer.parseInt(date.substring(5, 7)) == 12) {
                    dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "/09" + date.substring(7);
                    }

                    if ((thoiLuong + "").equals("12")) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 1 + "" + date.substring(4);
                    }
                    if ((thoiLuong + "").equals("24")) {
                      dateEnd = Integer.parseInt(date.substring(0, 4)) + 2 + "" + date.substring(4);
                    }
                    
                    if ("Chuyen khoan ngan hang VCB. STK: 123456789123, Ten chu khoan: Nguyen Van A".equals(hinhThucThanhToan)) {
                      hinhThucThanhToan = "Da chuyen khoan";
                    } else {
                      hinhThucThanhToan = "Tien mat";
                    }
                    
                    orderModel.insert(dichVu, user, vung, "order", date, diaChiNapDat, thoiLuong, dateEnd, hinhThucThanhToan);
                    
                    request.setAttribute("message", "Bạn đăng ký thành công gói dịch vụ " + dichVu.getTenDichVu() + "<br>Chúng tôi sẽ liên hệ trong vòng 24h.");
                    
                    if (!"".equals(username) && !"null".equals(username)) {
                        List<Order> listOrder = orderModel.getListOrderByUsername("order", username);
                        request.setAttribute("listOrder", listOrder);
                    }
                    
                    String msg = request.getParameter("msg");
                    
                    request.setAttribute("msg", msg);
                    request.setAttribute("tenMenu", "Tai khoan");
                    request.setAttribute("listDichVuAccepted", listDichVuAccepted);

                    RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("index.jsp");
                    requestDispatcher1.forward(request, response);
                    return;
                }
            }
            
        }
        
        if (!"".equals(username) && !"null".equals(username)) {
            List<Order> listOrder = orderModel.getListOrderByUsername("order", username);
            request.setAttribute("listOrder", listOrder);
        }
        
        request.setAttribute("tenMenu", "Cac goi dich vu");
        request.setAttribute("listDichVuAccepted", listDichVuAccepted);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

}
