package jdbcTests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

   @Test
   public void Test1(){

      DBUtils.createConnection();
      String query= "Select * from Employees";
      List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);
      for (Map<String, Object> map : queryResultMap) {
         System.out.println(map);
      }
DBUtils.destroy();

   }
}
