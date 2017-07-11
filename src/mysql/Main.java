package mysql;

import java.sql.SQLException;




public class Main {
    
    
    

    public static void main(String[] args) throws SQLException {

        
        
        MySQLConnect connection = new MySQLConnect();

        
        if (connection.connectToMysql("localhost", "db_test", "root", "")) {

            Query q = new Query(connection.getCon());

            /**
             * @para - SpaltenNname -> default "*"
             * @para - TabelenName 
             */
            q.showAll("", "tbl_kunde");

           
        } 
        else {

            System.out.println("Verbindung fehlgeschlagen");
        }

    }

}
