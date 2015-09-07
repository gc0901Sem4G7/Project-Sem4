package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doituong.DichVu;
import model.admin.AdminDealerModel;
import model.admin.AdminDichVuModel;

public class DoThemMoiDichVu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DoThemMoiDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDichVuModel adminDichVuModel = new AdminDichVuModel();
        
        AdminDealerModel adminDealerModel = new AdminDealerModel();
        
        String tenDichVu = request.getParameter("tenDichVu");
        String giaDichVu = request.getParameter("giaDichVu");
        String moTa = request.getParameter("moTa");
        
        String username = request.getSession().getAttribute("username") + "";
        int dealerId = adminDealerModel.getDealerByUsername(username).getId();
        
        String trangThai = "waiting";
        
        DichVu obj = new DichVu(tenDichVu, giaDichVu, moTa, dealerId, trangThai);
        
        boolean isInsert = adminDichVuModel.insert(obj, "dich_vu");
        System.out.println(isInsert);
        if (isInsert) {

            List<DichVu> listDichVu = adminDichVuModel.getAllDichVu("dich_vu");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
            request.setAttribute("request", "cacGoiDichVu");
            request.setAttribute("listDichVu", listDichVu);

            request.setAttribute("status", "success");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dichvu/themMoiDichVu.jsp");
            request.setAttribute("status", "Insert Failure");
            requestDispatcher.forward(request, response);
        }
    }

}
