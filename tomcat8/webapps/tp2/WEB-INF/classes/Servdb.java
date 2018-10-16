import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servdb")
public class Servdb extends HttpServlet {
    public void service( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException {

        PrintWriter out = res.getWriter();
            try{
                Class.forName("org.postgresql.Driver").newInstance();
                String url = "jdbc:postgresql://localhost:8080/servdb";
                String nom = "tc";
                String mdp = "tc";
                Connection con = DriverManager.getConnection(url, nom, mdp );
                String query = "SELECT * FROM utilisateurs";
                PreparedStatement ps = con.prepareStatement( query );
                ResultSet rs = ps.executeQuery();
                res.setContentType("text/html;charset=UTF­8");
                out.println( "<html><head><title>servlet</title>" );
                out.println( "<META content=\"charset=UTF­8\"></head><body>");
                out.println("Contenu de la table");
                while (rs.next()) {
                    String n = rs.getString("xxxxxx");
                    out.println(n);
                }
                out.println( "</body></html>" );
            }catch (Exception e) {out.println(e);}
    }
}