package com.servlets;

import com.dao.UserDAO;
import com.dao.UserRepo;
import com.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    public void init() {
        userDAO = new UserDAO();
    }

    private static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginUser(req, resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userDAO.getUserByLogin(req.getParameter("login"));
        if (user != null){
            if(user.getPassword().equals(req.getParameter("password"))){
                req.getSession().setAttribute("idUser", user.getId());
                getServletContext().getRequestDispatcher("/infousers.jsp").forward(req, resp);
            } else {
                logger.warn("incorrect password for the user: " + user.getLogin());
                req.setAttribute("errorMessage", "Password wrong");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "User not found");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserRepo.searchUser(req.getParameter("login"));
        if (user != null){
            if(user.getPassword().equals(req.getParameter("password"))){
                req.getSession().setAttribute("user", user);
                getServletContext().getRequestDispatcher("/infousers.jsp").forward(req, resp);
            } else {
                logger.warn("incorrect password for the user: " + user.getLogin());
                req.setAttribute("errorMessage", "Password wrong");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "User not found");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
