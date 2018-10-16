package tp1;

import java.sql.*;

public class JdbcPSql {
    public static void main(String[] args) {
        //On gère deux type d’exceptions ClassNotFound (pb avec Driver) et SQLException (pb requêtes SQL)
        try {
            Class.forName("org.postgresql.Driver");
            String url = url = "jdbc:postgresql://172.16.64.128/mabase";
            String login = "newuser";
            String mdp = "pass";

            //On essaye de se connecter à la base
            Connection conn = DriverManager.getConnection(url,login,mdp);
            if (conn != null) {
                System.out.println("Connected to the database");

                // un Statement est une interface qui représente une instruction SQL
                Statement stat = conn.createStatement();

                // On exécute les requêtes, attention à la différence entre executeUpdate et executeQuery
                stat.executeUpdate("insert into utilisateur values(1, 'Charles', 'Atan');");
                stat.executeUpdate("insert into utilisateur values(2, 'Paul', 'Auchon');");
                stat.executeUpdate("insert into utilisateur values(3, 'Pierre', 'Quiroule');");
                
                stat.executeUpdate("insert into result values(1, 2, 1)");
                stat.executeUpdate("insert into result values(2, 5, 1)");
                stat.executeUpdate("insert into result values(3, 8, 1)");
                stat.executeUpdate("insert into result values(4, 14, 2)");
                stat.executeUpdate("insert into result values(5, 8, 2)");
                stat.executeUpdate("insert into result values(6, 12, 2)");
                stat.executeUpdate("insert into result values(7, 17, 3)");
                stat.executeUpdate("insert into result values(8, 14, 3)");
                stat.executeUpdate("insert into result values(9, 19, 3)");

                // le resultat du select est mis dans un ResultSet
                ResultSet rs = stat.executeQuery("SELECT * FROM utilisateur;");
                while (rs.next()) {
                    int idjava = rs.getInt("id");
                    String nomjava = rs.getString("nom");
                    String prenomjava = rs.getString("prenom");
                    System.out.println("ID = " + idjava + " Prenom = " + prenomjava + " Nom = " + nomjava);
                }
                System.out.println();

                rs = stat.executeQuery("SELECT * FROM result");
                while (rs.next()) {
                    int idJava = rs.getInt("id");
                    int noteJava = rs.getInt("note");
                    int id_utilissateursJava = rs.getInt("id_utilisateur");
                    System.out.println("ID = " + idJava + " Note = " + noteJava + " Id_utilisateur = " + id_utilissateursJava);
                }
                System.out.println();

                rs = stat.executeQuery("SELECT prenom, nom, note FROM utilisateur " +
                        "INNER JOIN result ON utilisateur.id = result.id_utilisateur;");
                while (rs.next()) {
                    String prenomJava = rs.getString("prenom");
                    String nomJava = rs.getString("nom");
                    int noteJava = rs.getInt("note");
                    System.out.println("Prénom = " + prenomJava + " Nom = " + nomJava + " Note = " + noteJava);
                }

                // On ferme les connexions au ResultSet, Statement et à la base
                rs.close();
                stat.close();
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
