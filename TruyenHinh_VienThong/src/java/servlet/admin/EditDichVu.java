package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doituong.DichVu;
import model.admin.AdminDichVuModel;

public class EditDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminDichVuModel adminDichVuModel = new AdminDichVuModel();
		
		DichVu dichVu = adminDichVuModel.getDichVuById(Integer.parseInt(id), "dich_vu");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dichvu/themMoiDichVu.jsp");
		request.setAttribute("action", "action-edit");
		request.setAttribute("dichVu", dichVu);
		requestDispatcher.forward(request, response);
	}

}
