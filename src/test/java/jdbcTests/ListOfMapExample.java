package jdbcTests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMapExample {
   String dbUrl = "jdbc:oracle:thin:@44.208.34.43:1521:XE";
   String dbUsername = "hr";
   String dbPassword = "hr";


   @Test
   public void test1() throws SQLException {
      Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from employees");
      ResultSetMetaData rmdb = resultSet.getMetaData();
      resultSet.next();
      List<Map<String, Object>> queryData = new ArrayList<>();
      Map<String, Object> row1 = new HashMap<>();
      row1.put(rmdb.getColumnName(1), resultSet.getString(1));
      row1.put(rmdb.getColumnName(2), resultSet.getString(2));
      row1.put(rmdb.getColumnName(3), resultSet.getString(3));
      row1.put(rmdb.getColumnName(4), resultSet.getString(4));

      resultSet.next();
      Map<String, Object> row2 = new HashMap<>();
      row2.put(rmdb.getColumnName(1), resultSet.getString(1));
      row2.put(rmdb.getColumnName(2), resultSet.getString(2));
      row2.put(rmdb.getColumnName(3), resultSet.getString(3));
      row2.put(rmdb.getColumnName(4), resultSet.getString(4));



      queryData.add(row1);
      queryData.add(row2);
      System.out.println(queryData);
   }

}
