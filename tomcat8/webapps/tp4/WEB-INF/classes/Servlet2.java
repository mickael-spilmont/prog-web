import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet-2")
public class Servlet2 extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    String nom = req.getParameter("prenom");
    int budget = Integer.parseInt(req.getParameter("budget"));
    int debit = Integer.parseInt(req.getParameter("debit"));

    if (budget - debit >= 0) {
      budget -= debit;
      out.print("<html><body>"
        + "Il vous reste " + budget + " Euro"
        + "</body></html>");
    }
    else {
      out.print("<html><body>"
        + "<p style=\"color:red\">"
        + "Fonds insufisant pour permettre cette opération."
        + "</p>"
        + "</body></html>");
    }
  }
}
