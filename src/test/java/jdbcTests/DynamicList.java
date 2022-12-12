package jdbcTests;

import com.sun.source.tree.WhileLoopTree;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicList {
   String dbUrl = "jdbc:oracle:thin:@44.208.34.43:1521:XE";
   String dbUsername = "hr";
   String dbPassword = "hr";


   @Test
   public void test1() throws SQLException {
      Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * from employees");
      List<Map<String, Object>> queryData = new ArrayList<>();
      ResultSetMetaData rmdb = resultSet.getMetaData();
      while (resultSet.next()) {
         Map<String, Object> row = new HashMap<>();
         for (int i = 1; i <= rmdb.getColumnCount(); i++) {
            row.put(rmdb.getColumnName(i), resultSet.getObject(i));
         }
         queryData.add(row);
      }

      for (Map<String, Object> each : queryData) {
         System.out.println(each);
      }
      resultSet.close();
      statement.close();
      connection.close();
   }

}
