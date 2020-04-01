package servlets;

import dao.UserHibernateDAO;
import service.UserService;
import util.DBHelper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService.getInstance().setDao(new UserHibernateDAO(DBHelper.getSessionFactory()));
        Long id = Long.parseLong(request.getParameter("id"));
        UserService.getInstance().deleteUser(id);
        response.sendRedirect("/serv");
    }
}  