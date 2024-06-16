import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=TZMDotNetCore;user=sa;password=sasa@123;trustServerCertificate=true";

//        try (Connection con = DriverManager.getConnection(connectionUrl);
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM user_tbl")) {
//
//            StringBuilder allData = new StringBuilder();
//
//            int columnCount = rs.getMetaData().getColumnCount();
//
//            while (rs.next()) {
////                System.out.println(rs.getString(1) + " " +
////                        rs.getString(2)+" "+ rs.getString(3)
////                        +" "+rs.getString(4));
//                for(int i = 1; i<= columnCount; i++){
//                    allData.append(rs.getString(i)).append("\t");
//                }
//                allData.append("\n");
//            }
//            System.out.println(allData.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Scanner input = new Scanner(System.in);
        String query = "INSERT INTO user_tbl (User_name, User_mobile, User_email, User_address) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the values for the placeholders (?)
            System.out.print("Enter your name : ");
            String name = input.nextLine();
            System.out.print("Enter your phone number : ");
            String phNo = input.nextLine();
            System.out.print("Enter your email : ");
            String email = input.nextLine();
            System.out.print("Enter your address : ");
            String address = input.nextLine();
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phNo);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, address);

            // Execute the insert command
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new row was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
