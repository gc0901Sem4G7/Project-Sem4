package servlet.admin;

import doituong.Dealer;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin.AdminDichVuModel;
import doituong.DichVu;
import doituong.Order;
import javax.servlet.http.HttpSession;
import model.OrderModel;
import model.UserModel;
import model.admin.AdminDealerModel;

public class AdminDichVuServlet extends HttpServlet {

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        String acction = request.getParameter("action");
        AdminDichVuModel adminDichVuModel = new AdminDichVuModel();
        AdminDealerModel adminDealerModel = new AdminDealerModel();
        UserModel userModel = new UserModel();
        HttpSession httpSession = request.getSession();
        String admin = httpSession.getAttribute("admin") + "";
        String mien = userModel.getMienOfDealerByUsername("dealer", admin);
        OrderModel orderModel = new OrderModel();
        int dealerId = 0;

        Dealer dealer = adminDealerModel.getDealerByUsername(admin);
        if (url.endsWith("/admin/do-them-moi-dich-vu")) {
            String tenDichVu = request.getParameter("tenDichVu");
            String giaDichVu = request.getParameter("giaDichVu");
            String moTa = request.getParameter("moTa");
            
            dealerId = dealer.getId();
            DichVu dichVu = new DichVu(tenDichVu, giaDichVu, moTa, dealerId, "waiting", mien);
            adminDichVuModel.insert(dichVu, "dich_vu");
        }
        if ("denied".equals(acction)) {
            int id = Integer.parseInt(request.getParameter("id"));
            adminDichVuModel.delete(id, "dich_vu");
        } else if ("accept".equals(acction)) {
            int id = Integer.parseInt(request.getParameter("id"));
            DichVu dichVuObj = adminDichVuModel.getDichVuById(id, "dich_vu");
            dichVuObj.setTrangThai("accepted");
            adminDichVuModel.update(dichVuObj, "dich_vu");
        } else if ("finish".equals(acction)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Order orderObj = orderModel.getOrderById("order", id);
            orderObj.setStatus("Da nop");
            orderModel.update(orderObj, "order");
        } else if ("cancel".equals(acction)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Order orderObj = orderModel.getOrderById("order", id);
            orderObj.setStatus("Da huy");
            orderModel.update(orderObj, "order");
        } 
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        
        if (url.endsWith("/admin/adminThemMoiDichVu")) {
            request.setAttribute("request", "adminThemMoiDichVu");
            requestDispatcher.forward(request, response);
            return;
        }
        
        
        List<Order> listOrder = orderModel.getListOrderByMien("order", mien);
        request.setAttribute("listOrder", listOrder);
        List<DichVu> listDichVu;
        if (mien.equals("admin")) {
            listDichVu = adminDichVuModel.getAllDichVu("dich_vu");
        } else {
            listDichVu = adminDichVuModel.getListDichVuByVung("dich_vu", mien);
        }
        request.setAttribute("listDichVu", listDichVu);
        request.setAttribute("request", "cacGoiDichVu");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

}
