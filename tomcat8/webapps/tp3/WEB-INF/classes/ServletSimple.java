import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet-simple")
public class ServletSimple extends HttpServlet {
  public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html><br>Le nom est : "
      +req.getParameter("nom")+"<br>"
      +"<br>Le prénom est : "
      +req.getParameter("prenom")+"<br><html>");
  }
}
