package jdbcTests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {
   String dbUrl = "jdbc:oracle:thin:@44.208.34.43:1521:XE";
   String dbUsername = "hr";
   String dbPassword = "hr";

   @Test
   public void test1() throws SQLException {
      Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from departments");

      while (resultSet.next()) {
         System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2) + " - " +
                 resultSet.getString(3) + " - " + resultSet.getString(4));
      }

      resultSet = statement.executeQuery("select * from regions");
      while (resultSet.next()) {
         System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
      }

      resultSet.close();
      statement.close();
      connection.close();
   }


   @Test
   public void test2() throws SQLException {
      Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
      Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      ResultSet resultSet = statement.executeQuery("select * from departments");

//      resultSet.last();
//      System.out.println(resultSet.getRow());
//
//      resultSet.beforeFirst();
//      while (resultSet.next()){
//         System.out.println(resultSet.getString(2));
//      }
//Database metaData
      DatabaseMetaData dbMetaData = connection.getMetaData();
//      System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
//      System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());
//      System.out.println("dbMetaData.getDatabaseProductVersion() = " + dbMetaData.getDatabaseProductVersion());
//      System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());
//      System.out.println("dbMetaData.getDriverVersion() = " + dbMetaData.getDriverVersion());


      //ResultSet metaData
      ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
//      System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());
//      System.out.println("resultSetMetaData.getColumnLabel(1) = " + resultSetMetaData.getColumnLabel(1));
//      System.out.println("resultSetMetaData.getColumnName(1) = " + resultSetMetaData.getColumnName(1));
//
//      System.out.println("resultSetMetaData.getCatalogName(1) = " + resultSetMetaData.getCatalogName(1));
//      System.out.println("resultSetMetaData.getColumnType(1) = " + resultSetMetaData.getColumnType(1));
//      System.out.println("resultSetMetaData.getColumnDisplaySize(1) = " + resultSetMetaData.getColumnDisplaySize(1));

      for (int i = 1; i <=resultSetMetaData.getColumnCount() ; i++) {
         System.out.print(resultSetMetaData.getColumnName(i) + " ");
      }



   }

}



