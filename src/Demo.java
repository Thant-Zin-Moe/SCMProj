import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TZMDotNetCore;user=sa;password=sasa@123;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_pizza")) {

            StringBuilder allData = new StringBuilder();

            int columnCount = rs.getMetaData().getColumnCount();

            while (rs.next()) {
//                System.out.println(rs.getString(1) + " " +
//                        rs.getString(2)+" "+ rs.getString(3)
//                        +" "+rs.getString(4));
                for(int i = 1; i<= columnCount; i++){
                    allData.append(rs.getString(i)).append("\t");
                }
                allData.append("\n");
            }
            System.out.println(allData.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
