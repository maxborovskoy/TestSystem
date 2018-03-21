package filters;

import entity.User;
import services.UserService;
import services.UserServiceImpl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    private UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        redirect(request, response, chain, getHttpSession((HttpServletRequest) request));
    }

    private void redirect(ServletRequest request, ServletResponse response, FilterChain chain, HttpSession session)
            throws IOException, ServletException {
        String uri = ((HttpServletRequest) request).getRequestURI();

        if (session == null &&
                !(uri.endsWith("login.jsp") || uri.endsWith("loginServlet"))) {
            ((HttpServletResponse) response).sendRedirect("login.jsp");
        } else {
            User user = null;
            if (session != null && (user = (User) session.getAttribute("user")) != null) {
                if(uri.endsWith("addTestForm.jsp")
                        || uri.endsWith("addQuestionForm.jsp")
                        || uri.endsWith("addAnswerForm.jsp")
                        || uri.endsWith("addAnswerForm")
                        || uri.endsWith("addQuestionForm")
                        || uri.endsWith("addTestForm")){
                    if(user.getTutor()){
                        chain.doFilter(request, response);
                    } else {
                        ((HttpServletResponse) response).sendRedirect("forbidden.jsp");
                    }
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                if (!(uri.endsWith("login.jsp") || uri.endsWith("loginServlet"))) {
                    ((HttpServletResponse) response).sendRedirect("login.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
    }

    private HttpSession getHttpSession(HttpServletRequest request) {
        return request.getSession();
    }

    @Override
    public void destroy() {

    }


}
