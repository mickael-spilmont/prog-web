import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/servlet-double")
public class ServletDouble extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html> <head><link rel=\"stylesheet\" type=\"text/css\" href=\"../style/tableau.css\"></head>"
      +"<body>"
      +"<h2>Données récupérées</h2>"
      +"<table>"
      +"<tr>"
      +   "<th>Nom</th>"
      +   "<th>Prénom</th>"
      +   "<th>Sexe</th>"
      +   "<th>Loisir</th>"
      +   "<th>Commentaires</th>"
      + "</tr>"
      + "<tr>"
      +   "<th>" + req.getParameter("nom") + "</th>"
      +   "<th>" + req.getParameter("prenom") + "</th>"
      +   "<th>" + req.getParameter("sexe") + "</th>"
      +   "<th>" + req.getParameter("loisir") + "</th>"
      +   "<th>" + req.getParameter("commentaire") + "</th>"
      + "</tr>"
      +"</table>"
      +"</body>"
      +"</html>");
  }

  public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<html><h2>Données récupérées</h2>"
      +"<table>"
      + "<tr>"
      +   "<th>Nom</th>"
      +   "<th>Prénom</th>"
      +   "<th>Sexe</th>"
      +   "<th>Loisir</th>"
      +   "<th>Commentaires</th>"
      + "</tr>"
      + "<tr>"
      +   "<th>" + req.getParameter("nom") + "</th>"
      +   "<th>" + req.getParameter("prenom") + "</th>"
      +   "<th>" + req.getParameter("sexe") + "</th>"
      +   "<th>" + req.getParameter("loisir") + "</th>"
      +   "<th>" + req.getParameter("commentaire") + "</th>"
      + "</tr>"
      +"</table>"
      +"</html>");
  }
}
