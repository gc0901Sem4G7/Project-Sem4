package servlet.admin;

import doituong.LienHe;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.admin.AdminFQAModel;

public class AdminProcessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL() + "";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        
//        LienHe lienHeObject = new AdminFQAModel().getInfoLienHe();
        
        requestDispatcher.forward(request, response);
        if (url.endsWith("lienHe")) {
            
//            request.setAttribute("lienHeObject", lienHeObject);
            request.setAttribute("contentRight", "lienHe");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
