package servlet.admin;

import doituong.FQA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FQAModel;
import model.admin.AdminFQAModel;

public class AdminFQAServlet extends HttpServlet {

    List<FQA> listFQA;
    AdminFQAModel adminFQAModel;
    FQA fqaObject;

    private void setRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (Exception ex) {
            
        }
        request.setAttribute("request", "FQA");
        FQA fqaObject = new FQA();
        adminFQAModel = new AdminFQAModel();
        if (id != 0) {
            fqaObject = adminFQAModel.getFQAById(id, "fqa");
            request.setAttribute("fqaObject", fqaObject);
        }
        
        FQAModel fqaModel = new FQAModel();
        listFQA = fqaModel.getAllFQA("fqa");
        
        
        request.setAttribute("listFQA", listFQA);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admin = request.getSession().getAttribute("admin") + "";
        
        
        setRequest(request, response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
