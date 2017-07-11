package mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;





public class MySQLConnect {

    private Connection con;

    public MySQLConnect() {

    }

    
    
    public boolean connectToMysql(String host, String database, String user, String passwd) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + passwd;
            this.con = (Connection) DriverManager.getConnection(connectionCommand);

            return true;

        } 
        catch (Exception ex) {

            return false;
        }

    }
    
    
    
    public Connection getConnect() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}
