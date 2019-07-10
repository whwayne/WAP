import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
                "        <span>Email: </span>\n" +
                "        <input type=\"password\" name=\"pwd\" /><br/>\n" +
                "        <button type=\"submit\">Submit</button>\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>";
        PrintWriter out = resp.getWriter();
        out.print(html);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//        PrintWriter out = resp.getWriter();//        String name = req.getParameter("usr");

        String username =  req.getParameter("usr");
        String password = req.getParameter("pwd");
        User user = new User(username, password);

        HttpSession session = req.getSession();
        session.setAttribute("userInfo", user );


    }
}
