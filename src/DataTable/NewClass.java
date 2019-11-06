/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gkalianan
 */
public class NewClass {
    public static void main(String[] args) {
        //User user = new User(1,"Dennis","blaaaaaaaaaaa",5);
        UserDaoSqlite db = new UserDaoSqlite();
  
        //System.out.println();
        List<User> studentSet = db.getAllUsers(); 
        for (int i = 0; i < studentSet.size(); i++) {
            //String arg = args[i];
            System.err.println(studentSet.get(i).getId());
            System.err.println(studentSet.get(i).getName());
            System.err.println(studentSet.get(i).getPass());
            System.err.println(studentSet.get(i).getAge());
            System.err.println("");
            
        }
        
    }
            
    
}
