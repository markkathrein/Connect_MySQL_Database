package mysql;

import java.sql.SQLException;




public class Main {
    
    
    

    public static void main(String[] args) throws SQLException {

        
        
        MySQLConnect connection = new MySQLConnect();

        
        if (connection.connectToMysql("localhost", "db_test", "root", "")) {

            /**
             * @para - SpaltenNname -> default "*"
             * @para - TabelenName 
             */
            connection.showAll("", "tbl_person");

           
        } 
        else {

            System.out.println("Verbindung fehlgeschlagen");
        }

    }

}
