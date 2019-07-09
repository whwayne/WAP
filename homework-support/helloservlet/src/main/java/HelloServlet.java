import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <form method=\"post\">\n" +
                "        <span>Name: </span>\n" +
                "        <input type=\"text\" name=\"usr\" /><br/>\n" +
                "        <span>Email: </span>\n" +
                "        <input type=\"email\" name=\"txtemail\" /><br/>\n" +
                "        <span>Problem: </span>\n" +
                "        <input type=\"text\" name=\"prob\" /><br/>\n" +
                "        <span>Problem description: </span><br/>\n" +
                "        <textarea id=\"prob_describe\" rows=\"5\" cols=\"33\"></textarea><br/>\n" +
                "        <button type=\"submit\">help</button>\n" +
                "    </form>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        PrintWriter out = resp.getWriter();
        out.print(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("usr");
        String email = req.getParameter("email");
        ServletContext sc = this.getServletContext();
        String supportEmail = sc.getInitParameter("support-email");
        out.print("Thank you! "+ name + " for contacting us. We should receive reply from us with in 24 hrs in your email address " + email + ". Let us know in our support email " + supportEmail + " if you don’t receive reply within 24 hrs. Please be sure to attach your reference " + Math.random()+ " in your email.");

    }
}
