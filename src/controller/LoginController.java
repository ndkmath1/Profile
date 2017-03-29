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
 * Created by Khanh Nguyen on 27/03/2017.
 */
@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = new Account(username, password);
        AccountDao accountDao = new AccountDao();
        RequestDispatcher requestDispatcher;
        account = accountDao.login(account);
        if(account==null){
            requestDispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("login","error");
            requestDispatcher.forward(request, response);
        }else{
            HttpSession session = request.getSession(true);
            if(session.getAttribute("currentUser")==null){
                UserInfo userInfo = accountDao.getUserInfo(account);
                session.setAttribute("currentUser", userInfo);
            }
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        RequestDispatcher requestDispatcher;
        if(session.getAttribute("currentUser")!=null){
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/profile.jsp");
            requestDispatcher.forward(request,response);
        }else{
            requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
