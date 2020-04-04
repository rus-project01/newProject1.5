package servlets.filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/admin")
public class LoginFilter implements Filter {
    UserService userService = UserService.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        User user = new User(req.getParameter("name"), req.getParameter("password"));
        if(!userService.existUser(user)) {
            if(req.getSession().getAttribute("roleAttribute") == null) {
                req.getSession().setAttribute("roleAttribute", userService.checkUserByName(user).getRole());
                req.getSession().setAttribute("nameAttribute", userService.checkUserByName(user).getName());
                req.getSession().setAttribute("passwordAttribute", userService.checkUserByName(user).getPassword());
            }
            if("admin".equals(req.getSession().getAttribute("roleAttribute"))) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if("user".equals(req.getSession().getAttribute("roleAttribute"))) {
                List<User> us = new ArrayList<>();
                us.add(new User(req.getParameter("name"), req.getParameter("password")));
                req.getSession().setAttribute("us", us);
                resp.sendRedirect("/user");
            }
        } else if(req.getSession().getAttribute("user") != null && req.getRequestURI().endsWith("admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if(req.getParameter("us") != null) {
            resp.sendRedirect("/user");
        }
        else {
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}


