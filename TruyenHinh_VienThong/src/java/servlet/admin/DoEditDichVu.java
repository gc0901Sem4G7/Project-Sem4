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

public class DoEditDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoEditDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String tenDichVu = request.getParameter("tenDichVu");
		String moTa = request.getParameter("moTa");
		AdminDichVuModel adminDichVuModel = new AdminDichVuModel();
		
                DichVu obj = new DichVu();
                obj = adminDichVuModel.getDichVuById(id, "dich_vu");
                
                obj.setTenDichVu(tenDichVu);
                obj.setMoTa(moTa);
                
		boolean isUpdate = adminDichVuModel.update(obj, "dich_vu");
		
		if (isUpdate) {
			List<DichVu> listDichVu = adminDichVuModel.getAllDichVu("dich_vu");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("listDichVu", listDichVu);
			
			request.setAttribute("status", "Update success");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("status", "Update Failure");
			requestDispatcher.forward(request, response);
		}
	}

}
