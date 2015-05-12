package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

        String user, password, dbUrl;
        String driver;
        Connection dbcon;

        public connexion(String usr, String passwd, String url, String drvr){
            this.user = usr;
            this.password = passwd;
            this.dbUrl = url;
            this.driver = drvr;
        }

        public Connection getConnexion() throws SQLException, ClassNotFoundException{
            try{
                Class.forName(this.driver);
                this.dbcon = DriverManager.getConnection(this.dbUrl, this.user, this.password);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Coucou class not found exception");
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Coucou sql exception");
            }
            return this.dbcon;
        }

        public void closeConnexion() throws SQLException{
            try{
                if (this.dbcon != null) {
                    this.dbcon.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

}
