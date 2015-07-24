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
import java.util.Date;
import javax.servlet.http.HttpSession;
import model.OrderModel;

public class DichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DichVuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
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
                } else if (vung.equals("") || vung.equals("null")) {
                    request.setAttribute("message", "Khi chọn miền bạn cần ấn nút Chấp Nhận");
                } else {
                    
                    String tenDichVu = dichVuModel.getDichVuById(Integer.parseInt(dichVuId), "dich_vu").getTenDichVu();
                    
                    dichVu = new DichVu();
                    user = new User();
                    
                    dichVu.setTenDichVu(tenDichVu);
                    user.setUsername(username);
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    
                    orderModel.insert(dichVu, user, vung, "order", date);
                    
                    request.setAttribute("message", "Bạn đăng ký thành công gói dịch vụ " + dichVu.getTenDichVu());
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
