package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin.AdminDichVuModel;
import doituong.DichVu;

public class AdminDichVuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        
        if (url.endsWith("/admin/adminThemMoiDichVu")) {
            request.setAttribute("request", "adminThemMoiDichVu");
            requestDispatcher.forward(request, response);
            return;
        }
        
        AdminDichVuModel adminDichVuModel = new AdminDichVuModel();
        List<DichVu> listDichVu = adminDichVuModel.getAllDichVu();
        request.setAttribute("listDichVu", listDichVu);
        request.setAttribute("request", "cacGoiDichVu");
        requestDispatcher.forward(request, response);
    }

}
