import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SupportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
       // String name = req.get
        out.print("Thank you! [Name] for contacting us. We should receive reply from us with in 24 hrs in your email address [Email Address]. Let us know in our support email [support email] if you don’t receive reply within 24 hrs. Please be sure to attach your reference [support_ticket_id] in your email.");

    }
}
