/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;

/**
 *
 * @author G.K #gkexxt@outlook.com
 */
import java.util.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class UserTable extends RowTableModel<User> {

    private static String[] COLUMN_NAMES
            = {
                "ID",
                "Name",
                "Pass",
                "Age"
            };

    UserTable() {
        super(Arrays.asList(COLUMN_NAMES));
        setRowClass(User.class);

        //setColumnClass(2, Boolean.class);
        //setColumnClass(3, Boolean.class);
    }

    @Override
    public Object getValueAt(int row, int column) {
        User user = getRow(row);

        switch (column) {
            case 0:
                return user.getId();
            case 1:
                return user.getName();
            case 2:
                return user.getPass();
            case 3:
                return user.getAge();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        User user = getRow(row);
        UserDaoSqlite db = new UserDaoSqlite();
        try {
                    switch (column) {
            case 0:
                user.setId(Integer.parseInt(value.toString()));
                break;
            case 1:
                user.setName((String) value);
                break;
            case 2:
                user.setPass((String) value);
                break;
            case 3:
                user.setAge(Integer.parseInt(value.toString()));
                break;
        }
        db.updateUser(user);
        fireTableCellUpdated(row, column);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: " + "error update db", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static void main(String[] args) {
        JButton one = new JButton("One");
        JButton two = new JButton("Two");
        JButton three = new JButton("Three");

        //  Use the custom model
        UserTable model = new UserTable();

        //  Use the BeanTableModel
//		BeanTableModel<JButton> model =
//			new BeanTableModel<JButton>(JButton.class, java.awt.Component.class);
        JPanel south = new JPanel();
        south.add(one);
        south.add(two);
        south.add(three);

        UserDaoSqlite db = new UserDaoSqlite();

        //System.out.println();
        List<User> studentSet = new ArrayList<>();
        studentSet.addAll(db.getAllUsers());
        for (int i = 0; i < studentSet.size(); i++) {
            //String arg = args[i];
            model.addRow(studentSet.get(i));

        }

        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(south, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        studentSet.get(0).setName("000022222");

    }
}
