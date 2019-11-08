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
import java.awt.Component;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class UserTable extends RowTableModel<User> {

    private static final ImageIcon iconstart = new ImageIcon(new ImageIcon("play.png")
            .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT));
    //System.out.println(value.toString());
    private static final JLabel labelStart = new JLabel(iconstart, JLabel.CENTER);
    private static final ImageIcon iconstop = new ImageIcon(new ImageIcon("stop.png")
            .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT));
    //System.out.println(value.toString());
    private static final JLabel labelStop = new JLabel(iconstop, JLabel.CENTER);
    private static String[] COLUMN_NAMES
            = {
                "ID",
                "Name",
                "Pass",
                "Age",
                "Status",
                "control"

            };

    UserTable() {
        super(Arrays.asList(COLUMN_NAMES));
        setRowClass(User.class);

        //setColumnClass(2, Boolean.class);
        setColumnClass(5, Boolean.class);
        setColumnEditable(0, false);
        setColumnEditable(4, false);
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
            case 4:
                return user.getStatusRunning();
            case 5:
                return user.getControl();
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
                case 5:
                    //System.out.println("DataTable.UserTable.setValueAt()");
                    if (user.getStatusRunning().equals("STOPPED")) {
                        user.setStatusRunning("STARTING");
                    } else if (user.getStatusRunning().equals("RUNNING")) {
                        user.setStatusRunning("STOPPING");
                    }
                    //user.setControl(!user.getControl());

                    break;
            }
            db.updateUser(user);
            fireTableCellUpdated(row, column);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "InfoBox: "
                    + "error update db", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static class JTableButtonRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String status = table.getModel().getValueAt(row, column).toString();
            System.out.println(status);
            if (status.equals("STOPPED")) {
                return labelStop;
            } else if (status.equals("STARTING")) {
                return new JLabel("starting");
            } else if (status.equals("STOPPING")) {
                return new JLabel("STARTING");
            } else {
                return new JLabel("RUNNING");
            }
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("control").setCellRenderer(buttonRenderer);
        TableColumnModel tcm = table.getColumnModel();
        tcm.removeColumn(tcm.getColumn(4));
        //table.removeColumn(aColumn);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().add(south, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        

        java.util.Timer t = new java.util.Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println(studentSet.get(0).getStatusRunning());
                if(studentSet.get(0).getStatusRunning().equals("STOPPED")){
                studentSet.get(0).setStatusRunning("RUNNING");
                }else{
                    studentSet.get(0).setStatusRunning("STOPPED");
                }
                model.fireTableDataChanged();
            }
            
        };  
        t.scheduleAtFixedRate(tt, 500, 2000);

    }
}
