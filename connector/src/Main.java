import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassCastException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/mydatabase";

        //connection to databse
        Connection conn = DriverManager.getConnection(url, "root", "root");
        System.out.println("connection success");

        // fetch data from database
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        System.out.println(resultSet);


        //prepaid statement
        //PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from mytable where id=?");
        //preparedStatement.setInt(1,10);
        //preparedStatement.setString(2,"Lamjung");
        //ResultSet resultSet= preparedStatement.executeQuery();

        while (resultSet.next()){
          System.out.println(resultSet.getInt("id") + "");
          System.out.println(resultSet.getString("name"));
          System.out.println("");
          System.out.println(resultSet.getString("address"));
          System.out.println("\n");
        }
    }
}