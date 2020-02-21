package com.servlets;



import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.entity.Role;
import com.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.entity.Role.USER;



@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(RegistrationServlet.class);
    UserDAO userDAO = new UserDAO();
    RoleDAO roleDAO = new RoleDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        Role role = roleDAO.getRole(USER);
        user.getRoles().add(role);
        String confirmPassword = req.getParameter("confirmpassword");
        if(userDAO.getUserByLogin(req.getParameter("login")) == null && user.getPassword().equals(confirmPassword)){
            userDAO.save(user);
            req.getSession().setAttribute("id", user.getId());
            req.getSession().setAttribute("users", userDAO.getAllUsers());
            logger.info("user " + user.getLogin() + " create");
            getServletContext().getRequestDispatcher("/editInfo.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "The username exists or confirm your password is correct");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }

    /*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        String confirmPassword = req.getParameter("confirmpassword");
        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setAdmin(Boolean.parseBoolean(req.getParameter("admin")));
        if(UserRepo.searchUser(user.getLogin()) == null && user.getPassword().equals(confirmPassword)){
            UserRepo.addUser(user);
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("users", UserRepo.getUsers());
            logger.info("user " + user.getLogin() + " create");
            getServletContext().getRequestDispatcher("/infousers.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "The username exists or confirm your password is correct");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
