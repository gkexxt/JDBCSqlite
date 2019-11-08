/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
/**
 *
 * @author G.K #gkexxt@outlook.com
 */
public class ListRenderer extends JFrame{
        public ListRenderer() {
            
        UserDaoSqlite db = new UserDaoSqlite();
  
        //System.out.println();
        List<User> studentSet = new ArrayList<> (); 
        studentSet.addAll(db.getAllUsers());
        //create the model and add elements
        
        DefaultListModel<User> listModel = new DefaultListModel<>();
            for (User listuser : studentSet) {
                listModel.addElement(listuser);
            }
        
        //create the list
        JList<User> userList = new JList<>(listModel);
        add(new JScrollPane(userList));
         userList.setCellRenderer(new UserRenderer());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Renderer Example");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListRenderer();
            }
        });
    }
}
