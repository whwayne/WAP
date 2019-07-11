import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession  session = request.getSession(false);

        String requestPath = request.getRequestURI();

        if (session == null || session.getAttribute("userInfo") == null) { // change "user" for the session attribute you have defined

            response.sendRedirect(request.getContextPath() + "/login"); // No logged-in user found, so redirect to login page.
        } else {
            filterChain.doFilter(request, response); // Logged-in user found, so just continue request.
        }




    }

    @Override
    public void destroy() {

    }


}
