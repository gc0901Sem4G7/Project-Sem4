package servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doituong.DichVu;
import java.io.PrintWriter;
import model.admin.AdminDichVuModel;

public class DoDeleteDichVu extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DoDeleteDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AdminDichVuModel adminDichVuModel = new AdminDichVuModel();

        String url = request.getRequestURI();
        PrintWriter out = response.getWriter();
        out.print("URL: " + url);

        boolean isDelete = adminDichVuModel.delete(Integer.parseInt(id), "dich_vu");
        if (isDelete) {
            List<DichVu> listDichVu = adminDichVuModel.getAllDichVu("dich_vu");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
            request.setAttribute("listDichVu", listDichVu);

            request.setAttribute("status", "success");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("status", "Delete Failure");
            requestDispatcher.forward(request, response);
        }
    }

}
