package servlet.admin;

import doituong.Dealer;
import doituong.OrderByTrangThai;
import doituong.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrderModel;
import model.UserModel;
import model.admin.AdminDealerModel;

public class AdminAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getRequestURI() + "";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("trangQuanTri.jsp");
        UserModel usermodel = new UserModel();
        OrderModel orderModel = new OrderModel();
        
        AdminDealerModel adminDealerModel = new AdminDealerModel();
        List<User> listUser = new ArrayList<User>();
        List<OrderByTrangThai> listOrderByTrangThai = new ArrayList<OrderByTrangThai>();
        List<Dealer> listDealer = new ArrayList<Dealer>();
        
        String mien = request.getSession().getAttribute("mien") + "";
        int idSendMail = 0;
        String emailSend = "";
        String tenGoiSend = "";
        try {
          idSendMail = Integer.parseInt(request.getParameter("idSendMail"));
          emailSend = request.getParameter("emailSend");
          tenGoiSend = request.getParameter("tenGoiSend");
        } catch (Exception e) {
          
        }
 
        
        if (url.endsWith("account-type")) {
            request.setAttribute("request", "account-type");
        } else if (url.endsWith("account-user")) {
            
            if (idSendMail != 0) {
              String from = "tungptgc00676@fpt.edu.vn";// hom truoc e bao e cung dung gmail mà
              // day la mail cua fpt mà NO LA GMAIL MA A
              String to = emailSend.trim(); // email nay la email cua user nam trong database

              final String username = from;
              final String password = "taolasvfptgw";

              // Assuming you are sending email through relay.jangosmtp.net
              String host = "smtp.gmail.com";

              Properties props = new Properties();
              props.put("mail.smtp.auth", "true");
              props.put("mail.smtp.starttls.enable", "true");
              props.put("mail.smtp.host", host);
              props.put("mail.smtp.port", "587");

              // Get the Session object.
              Session session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                 }
              });

              try {
                 // Create a default MimeMessage object.
                 Message message = new MimeMessage(session);

                 // Set From: header field of the header.
                 message.setFrom(new InternetAddress(from));

                 // Set To: header field of the header.
                 message.setRecipients(Message.RecipientType.TO,
                 InternetAddress.parse(to));

                 // Set Subject: header field
                 message.setSubject("Truyen Hinh::Gia han goi");

                 // Now set the actual message
                 message.setText("Cam on ban thoi gian qua da su dung goi truyen " + tenGoiSend + " hinh cua chung toi.\n"
                         + "Goi truyen hinh cua ban con duoi 1 thang. Vui long truy cap website truyenhinhvienthong.com de gia han hoac lien he den so dien thoai 043.666.888 de duoc gia han.\n"
                         + "Xin cam on");

                 // Send message
                 Transport.send(message);

                 System.out.println("Sent message successfully....");
                 request.setAttribute("sendMailSuccess", "Gui email thong bao gia han thanh cong!");

              } catch (Exception e) {
                    throw new RuntimeException(e);
              }
            }
          
            listOrderByTrangThai = orderModel.getAllOrderByMien(mien);
            
            request.setAttribute("listOrderByTrangThai", listOrderByTrangThai);
            request.setAttribute("request", "account-type-user");
        } else if (url.endsWith("account-admin")) {
            String action = request.getParameter("action");
            boolean isDelete = false;
            try {
                String id = request.getParameter("id");
                if ("delete".equals(action)) {
                    int idInt = Integer.parseInt(id);
                    adminDealerModel.deleteDealer(idInt, "dealer");
                    isDelete = true;
                } else if ("edit".equals(action)) {
                    int idInt = Integer.parseInt(id);
                    Dealer dealer = adminDealerModel.getDealerById(idInt);
                    request.setAttribute("dealer", dealer);
                    request.setAttribute("request", "admin account admin edit");
                    requestDispatcher.forward(request, response);
                    return;
                }
            } catch (Exception ex) {
                
            }
            
            listDealer = adminDealerModel.getAllListDealer();
            request.setAttribute("listDealer", listDealer);
            request.setAttribute("request", "account-type-admin");
        } else if (url.endsWith("doEditAccountAdmin")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            Dealer dealer = new Dealer(id, username, password, name, sex, email, phone, address, mien);
            adminDealerModel.updateDealer("dealer", dealer);
            
            listDealer = adminDealerModel.getAllListDealer();
            request.setAttribute("listDealer", listDealer);
            request.setAttribute("request", "account-type-admin");
        } else if (url.endsWith("pageAddDealer")) {
            request.setAttribute("request", "pageAddDealer");
        } else if (url.endsWith("doAddAccountAdmin")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            
            Dealer dealer = new Dealer(username, password, name, sex, email, phone, address, mien);
            adminDealerModel.insertDealer(dealer, "dealer");
            listDealer = adminDealerModel.getAllListDealer();
            request.setAttribute("listDealer", listDealer);
            request.setAttribute("request", "account-type-admin");
        }
        
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
