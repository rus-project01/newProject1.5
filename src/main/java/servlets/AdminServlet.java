package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.User;
import service.UserService;

@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
    UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = userService.getAllUsers();
        req.getSession().setAttribute("user", user);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        Long money = Long.parseLong(req.getParameter("money"));
        userService.addUser(new User(name, password, money, role));
        req.getRequestDispatcher("/succesfulEdition.jsp").forward(req, resp);
    }
}
