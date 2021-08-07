package pl.coderslab.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {

    private static userDAO userDao = new userDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        User user = userDao.read(Integer.parseInt(id));
        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/delete.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        User user = userDao.read(Integer.parseInt(id));
        req.setAttribute("user", user);
        userDAO.delete(Integer.parseInt(id));

        getServletContext().getRequestDispatcher("/WEB-INF/POSTdelete.jsp")
                .forward(req, resp);

    }
}

