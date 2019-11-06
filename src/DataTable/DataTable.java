/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;
import java.sql.*;
/**
 *
 * @author gkalianan
 */
public class DataTable {

    /**
     * @param args the command line arguments
     */
  public static void main( String args[] ) {
 
      
      Statement stmt = null;
      
      try {
         
         
         Connection c = ConnectionFactory.getConnection();
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE user " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " + 
                        " PASS           CHAR(50)     NOT NULL, " + 
                        " AGE            INT, " + 
                        " UUID           CHAR(36))"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
   }
    
}
