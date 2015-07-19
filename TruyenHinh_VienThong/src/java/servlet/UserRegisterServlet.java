package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;
import doituong.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserRegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tenMenu", "register");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String cardId = request.getParameter("card_id");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int packageId = Integer.parseInt(request.getParameter("package_id"));
        int dealerId = Integer.parseInt(request.getParameter("dealer_id"));
        
        
        System.out.println(packageId);
        User user = new User(username, password, name, cardId, phoneNumber, email, address, packageId, dealerId);

        UserModel userModel = new UserModel();
        boolean isInsert = userModel.insert(user, "user");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        request.setAttribute("tenMenu", "register");
        if (isInsert) {
            request.setAttribute("message", "Đăng ký thành công");
        } else {
            request.setAttribute("message", "Đăng ký không thành công");
        }

        dispatcher.forward(request, response);
    }

}
