package com.servlets;

import com.dao.UserDAO;
import com.entity.InfoUser;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editInfo")
public class EditInfoServlet extends HttpServlet {
    UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InfoUser infoUser = new InfoUser();
        infoUser.setAge(Integer.parseInt(req.getParameter("age")));
        infoUser.setName(req.getParameter("name"));
        infoUser.setCity(req.getParameter("city"));
        User user = userDAO.findById((Integer) req.getSession().getAttribute("id"));
        user.setInfoUser(infoUser);
        userDAO.save(user);
        req.getSession().setAttribute("user", user);
        getServletContext().getRequestDispatcher("/infousers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
