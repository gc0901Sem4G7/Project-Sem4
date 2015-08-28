package servlet;

import doituong.FQA;
import doituong.User;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FQAModel;

public class FQAServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    List<FQA> listFQA;
    FQAModel fqaModel;
    FQA fqaObject;
    
    public FQAServlet() {
        super();
    }

    private void setRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FQAModel fqaModel = new FQAModel();
        listFQA = fqaModel.getAllFQA("fqa");
        request.setAttribute("tenMenu", "FQA");
        request.setAttribute("listFQA", listFQA);
    }
    
    protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isInsert = false;
        String cauHoi = request.getParameter("cauHoi") + "";
        String admin = request.getSession().getAttribute("username") + "";
        if (!"".equals(admin) && !"null".equals(admin) && !"".equals(cauHoi) && !"null".equals(cauHoi)) {
            if (!isInsert) {
                fqaModel = new FQAModel();
                fqaObject = new FQA(cauHoi, "", admin, "pending");
                fqaModel.insert(fqaObject, "fqa");
                isInsert = true;
            }
        } else {
            request.setAttribute("message", "Ban chua dang nhap");
        }
        
        setRequest(request, response);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
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
