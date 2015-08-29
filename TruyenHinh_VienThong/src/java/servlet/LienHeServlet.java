package servlet;

import doituong.LienHe;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LienHeModel;

public class LienHeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LienHeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tenMenu", "Lien he");
		
                LienHeModel obj = new LienHeModel();
                LienHe lienHe = obj.getInfoLienHe();
                
                request.setAttribute("lienHe", lienHe);
                
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}

}
