package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.admin.AdminModel;

public class AdminLoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminModel adminModel = new AdminModel();

        HttpSession httpSession = request.getSession();

        String mien = adminModel.checkLoginAdmin(username, password).toString();
        if (mien != "") {
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("mien", mien);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
            request.setAttribute("status", "success");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("status", "Login Failure");
            requestDispatcher.forward(request, response);
        }
    }

}
