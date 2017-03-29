package controller;

import dao.AccountDao;
import model.Account;
import model.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Khanh Nguyen on 28/03/2017.
 */
@WebServlet(name = "UpdateController")
public class UpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String fullname = request.getParameter("fullname");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String hobie = request.getParameter("hobie");
        String phone = request.getParameter("phone");
        String description = request.getParameter("description");

        RequestDispatcher requestDispatcher;
        AccountDao accountDao = new AccountDao();
        HttpSession session = request.getSession(true);
        if(session.getAttribute("currentUser")!=null){
            Account account = ((UserInfo)session.getAttribute("currentUser")).getAccount();
            UserInfo userInfo = new UserInfo(fullname,birthday,address,hobie,description,phone,account);
            if(accountDao.update(userInfo)){
                session.setAttribute("currentUser",userInfo);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
                requestDispatcher.forward(request,response);
            }else{
                request.setAttribute("update","error");
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
                requestDispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession(true);
        RequestDispatcher requestDispatcher;
        if(session.getAttribute("currentUser")!=null){
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
            requestDispatcher.forward(request,response);
        }else{
            requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
