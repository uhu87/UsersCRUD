package pl.coderslab.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/user/list")
public class UserList extends HttpServlet {

    private static userDAO userDao = new userDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User[]users= userDAO.findAll();

    request.setAttribute("users",users);

    getServletContext().getRequestDispatcher("/WEB-INF/list.jsp")
                .forward(request, response);

}

}
