
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Login Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form method=\"post\">\n" +
                "        <span>Name: </span>\n" +
                "        <input type=\"text\" name=\"usr\" /><br/>\n" +
                "        <span>Password: </span>\n" +
                "        <input type=\"password\" name=\"pwd\" /><br/>\n" +
                "        <input type=\"checkbox\" name=\"pwd\" value=\"yes\"/> remember me<br/>\n" +
        "        <button type=\"submit\">Login</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        PrintWriter out = resp.getWriter();
        out.print(html);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("usr");
        String password = req.getParameter("pwd");

        if(username.equals("wh") && password.equals("123")) {

            out.print("Welcome, " + username);
            HttpSession session = req.getSession();
            session.setAttribute("userInfo", username);
            session.setMaxInactiveInterval(30);
            Cookie cookie = new Cookie(username, password);
            cookie.setMaxAge(3600 * 24 * 30); //in seconds
            resp.addCookie(cookie);

            resp.sendRedirect("welcome.jsp");

        }else {
                //resp.sendRedirect("/login");
            out.print("Sorry, username or password error!");
            req.getRequestDispatcher("/login").include(req, resp);

        }


    }
}