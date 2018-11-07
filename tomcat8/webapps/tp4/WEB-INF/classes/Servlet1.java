import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet-1")
public class Servlet1 extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    int budget;
    String nom = req.getParameter("prenom");

    switch (nom) {
      case "Pierre" :
        budget = 100;
        break;
      case "Paul" :
        budget = 200;
        break;
      default :
        budget = 50;
    }

    out.print("<html><body>"
      + "Bonjour " + nom + " votre budget est de : " + budget + " Euro"
      + "<br><br>"
      + "<form action=\"http://localhost:8080/tp4/servlet-2\" method=\"get\">"
      +   "Combien souhaitez vous débiter ?" + "\t"
      +   "<input type=\"number\" name=\"debit\" min=\"0\" value=\"0\" step=\"10\""
      +   "<br><br><br>"
      +   "<input type=\"submit\" value=\"Valider\">"
      +   "<input type=\"hidden\" name=\"prenom\" value=\"" + nom + "\">"
      +   "<input type=\"hidden\" name=\"budget\" value=\"" + budget + "\">"
      + "</form>"
      + "</html></body>");
  }
}
