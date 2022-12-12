package jdbcTests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String dbUrl="jdbc:oracle:thin:@44.208.34.43:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from regions");

//        resultSet.next();
//        System.out.println(resultSet.getString(1));
while (resultSet.next()) {
    System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
}
        resultSet.close();
        statement.close();
        connection.close();
    }
}
