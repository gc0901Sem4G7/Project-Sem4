package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserModel;
import doituong.User;


public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String message = "";
		UserModel userModel = new UserModel();
		
		HttpSession session = request.getSession();
		
		boolean isCheckLoginUser = false;
		isCheckLoginUser = userModel.checkLoginUser(username, password);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		
		if (isCheckLoginUser) {
			session.setAttribute("username", username);
			message = "Login Success";
			request.setAttribute("message", message);
		} else {
			message = "Login Failure";
			request.setAttribute("message", message);
		}
		
		PrintWriter out = response.getWriter();
		out.print(message);
		dispatcher.forward(request, response);
	}

}
