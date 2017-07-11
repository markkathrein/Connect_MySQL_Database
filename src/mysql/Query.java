package mysql;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Query {

    
    
    private Connection con;

    
    
    public Query(Connection con) {
        this.con = con;
    }

    
    
    
    
    
    
    
    
    
    public void showAll(String nameOfColumn, String nameOfTable) throws SQLException {

        if (nameOfColumn == "") {
            nameOfColumn = "*";
        }

        int columns;
        String query = "SELECT " + nameOfColumn + " FROM " + nameOfTable;
        List<String> tableTitel = new ArrayList<>();
        List<String> tableContent = new ArrayList<>();

        // TRY ABFAGE
        try (
                Statement stmt = this.con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            // ANZAHL Spalten
            columns = rs.getMetaData().getColumnCount();
            System.out.println("Spalten : " + columns + "\n\n");

            // SpaltenTitel
            for (int i = 1; i <= columns; i++) {

                // Speicherung SpaltenTitel Liste
                tableTitel.add(rs.getMetaData().getColumnLabel(i));

                // Ausgabe temp
                // System.out.print(rs.getMetaData().getColumnLabel(i) + "\t\t");
            }

            for (String a : tableTitel) {

                System.out.print(a.toString() + "\t\t");
            }

            System.out.print("\n");

            // Speicherung Liste TableContent
            while (rs.next()) {

                for (int i = 1; i <= columns; i++) {

                    // Speicherung Liste TableContent
                    tableContent.add(rs.getString(i));
                }
            }

            int o = 0;
            for (int j = 0; j < tableContent.size(); j++) {

                if (o < columns) {

                    System.out.print(tableContent.get(j).toString() + "\t\t");
                } else {
                    System.out.println();
                    System.out.print(tableContent.get(j).toString() + "\t\t");
                    o = 0;
                }
                o++;
            }

        }

    }
    
    
    
    
    
    
}
