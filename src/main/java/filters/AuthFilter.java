package filters;

import entity.User;
import services.api.UserService;
import services.impl.UserServiceImpl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

    private static final String FORBIDDEN_JSP = "forbidden.jsp";
    private static final String LOGIN_JSP = "login.jsp";
    private static final String USER = "user";
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

        if (isResourcesPages(uri)) {
            chain.doFilter(request, response);
        } else {
            User user = null;
            if (session != null && (user = (User) session.getAttribute(USER)) != null) {
                if (isTutorPages(uri)) {
                    if (user.getTutor()) {
                        chain.doFilter(request, response);
                    } else {
                        ((HttpServletResponse) response).sendRedirect(FORBIDDEN_JSP);
                    }
                } else {
                    chain.doFilter(request, response);
                }
            } else {
                if (isNotLoginPages(uri)) {
                    ((HttpServletResponse) response).sendRedirect(LOGIN_JSP);
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
    }

    private boolean isResourcesPages(String uri) {
        return uri.startsWith("/css")
                || uri.startsWith("/js")
                || uri.startsWith("/language")
                || uri.startsWith("/images");
    }


    private boolean isNotLoginPages(String uri) {
        return !(uri.endsWith("login.jsp")
                || uri.endsWith("loginServlet")
                || uri.endsWith("registration.jsp")
                || uri.endsWith("registrationServlet"));
    }



    private boolean isTutorPages(String uri) {
        return uri.endsWith("addTestForm.jsp")
                || uri.endsWith("addQuestionForm.jsp")
                || uri.endsWith("addAnswerForm.jsp")
                || uri.endsWith("addAnswerForm")
                || uri.endsWith("addQuestionForm")
                || uri.endsWith("addTestForm")
                || uri.endsWith("editor")
                || uri.endsWith("editor.jsp")
                || uri.endsWith("userList.jsp")
                || uri.endsWith("userListServlet");

    }

    private HttpSession getHttpSession(HttpServletRequest request) {
        return request.getSession();
    }

    @Override
    public void destroy() {

    }


}
