package tp1;

import java.sql.*;

public class JdbcSqlite {
    public static void main(String[] args) {
        //On gère deux type d’exceptions ClassNotFound (pb avec Driver) et SQLException (pb requêtes SQL)
        try {
            // On déclare le type de driver JDBC et le chemin d’accès à la base, si pb exception ClassNotFound
            Class.forName("org.sqlite.JDBC");
            // String dbURL = "jdbc:sqlite:maBase.db";
            String dbURL = "jdbc:sqlite:/home/mickael/Code/Prog-web/ressources/sqlite/maBase.db";

            //On essaye de se connecter à la base
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");

                // un Statement est une interface qui représente une instruction SQL
                Statement stat = conn.createStatement();

                // On exécute les requêtes, attention à la différence entre executeUpdate et executeQuery
                stat.executeUpdate("drop table if exists t1");
                stat.executeUpdate("create table t1(id int, prenom vchar(10), nom vchar(10));");
                stat.executeUpdate("insert into t1 values(1, 'Charles', 'Atan');");
                stat.executeUpdate("insert into t1 values(2, 'Paul', 'Auchon');");
                stat.executeUpdate("insert into t1 values(3, 'Pierre', 'Quiroule');");

                stat.executeUpdate("drop table if exists t2");
                stat.executeUpdate("create table t2(id int, note int, id_utilisateur int)");
                stat.executeUpdate("insert into t2 values(1, 2, 1)");
                stat.executeUpdate("insert into t2 values(2, 5, 1)");
                stat.executeUpdate("insert into t2 values(3, 8, 1)");
                stat.executeUpdate("insert into t2 values(4, 14, 2)");
                stat.executeUpdate("insert into t2 values(5, 8, 2)");
                stat.executeUpdate("insert into t2 values(6, 12, 2)");
                stat.executeUpdate("insert into t2 values(7, 17, 3)");
                stat.executeUpdate("insert into t2 values(8, 14, 3)");
                stat.executeUpdate("insert into t2 values(9, 19, 3)");

                // le resultat du select est mis dans un ResultSet
                ResultSet rs = stat.executeQuery("SELECT * FROM t1;");
                while (rs.next()) {
                    int idjava = rs.getInt("id");
                    String nomjava = rs.getString("nom");
                    String prenomjava = rs.getString("prenom");
                    System.out.println("ID = " + idjava + " Prenom = " + prenomjava + " Nom = " + nomjava);
                }
                System.out.println();

                rs = stat.executeQuery("SELECT * FROM t2");
                while (rs.next()) {
                    int idJava = rs.getInt("id");
                    int noteJava = rs.getInt("note");
                    int id_utilissateursJava = rs.getInt("id_utilisateur");
                    System.out.println("ID = " + idJava + " Note = " + noteJava + " Id_utilisateur = " + id_utilissateursJava);
                }
                System.out.println();

                rs = stat.executeQuery("SELECT prenom, nom, note FROM t1 " +
                        "INNER JOIN t2 ON t1.id = t2.id_utilisateur;");
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
