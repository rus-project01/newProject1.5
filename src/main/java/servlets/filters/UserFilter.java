package servlets.filters;

import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/user")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute("us") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if(req.getSession().getAttribute("user") != null) {
            if(req.getSession().getAttribute("us") == null) {
                List<User> list = new ArrayList<>();
                list.add(new User((String) req.getSession().getAttribute("nameAttribute"), (String) req.getSession().getAttribute("passwordAttribute")));
                req.getSession().setAttribute("us", list);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
