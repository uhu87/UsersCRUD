package pl.coderslab.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    private static userDAO userDao = new userDAO();

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        User user = userDao.read(Integer.parseInt(id));

        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/edit.jsp")
                .forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        User user = userDao.read(Integer.parseInt(id));
        String username = req.getParameter("userName");
        String useremail = req.getParameter("userEmail");
        String userpassword = req.getParameter("userPassword");

        userDAO.update2(user,username,useremail,userpassword);

        resp.sendRedirect("/user/show?id="+id);


    }
}

