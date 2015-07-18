package servlet.admin;

import doituong.LienHe;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LienHeModel;
import model.admin.AdminFQAModel;

public class AdminLienHeServlet extends HttpServlet {

    protected void doRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lienHe = "lienHe";
        String adminEditLienHe = "adminEditLienHe";
        String adminDoEditLienHe = "adminDoEditLienHe";

        LienHeModel lienHeModel = new LienHeModel();
        LienHe lienHeObject = lienHeModel.getInfoLienHe();
        
        String url = request.getRequestURL() + "";
        if (url.endsWith(lienHe)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
//            request.setAttribute("lienHeObject", lienHeObject);
            request.setAttribute("request", lienHe);
            request.setAttribute("lienHeObject", lienHeObject);
            requestDispatcher.forward(request, response);
            
        } else if (url.endsWith(adminEditLienHe)) {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
//            request.setAttribute("lienHeObject", lienHeObject);
            request.setAttribute("request", adminEditLienHe);
            requestDispatcher.forward(request, response);
            
        } else if (url.endsWith(adminDoEditLienHe)) {
            String id = request.getParameter("id");
            String diaChi = request.getParameter("diaChi");
            String dienThoai = request.getParameter("dienThoai");
            String tenCongTy = request.getParameter("tenCongTy");
            String email = request.getParameter("email");
            String skype = request.getParameter("skype");
            
//            lienHeObject = new LienHe(Integer.parseInt(id), diaChi, dienThoai, tenCongTy, email, skype);
//            new AdminFQAModel().updateInfoLienHe(lienHeObject);
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
//            request.setAttribute("lienHeObject", lienHeObject);
            request.setAttribute("request", lienHe);
            requestDispatcher.forward(request, response);
            
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

}
