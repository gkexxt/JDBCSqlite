package DataTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G.K #gkexxt@outlook.com
 */

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
 
/**
 * Custom renderer to display a country's flag alongside its name
 *
 * @author wwww.codejava.net
 */
public class UserRenderer extends JLabel implements ListCellRenderer<User> {
 
    public UserRenderer() {
        setOpaque(true);
    }
 
    @Override
    public Component getListCellRendererComponent(JList<? extends User> list, User user, int index,
            boolean isSelected, boolean cellHasFocus) {
 
        //String code = user.;
        //ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + code + ".png"));
 
        //setIcon(imageIcon);
        setText(user.getId().toString());
        setText(user.getName());
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
 
        return this;
    }
} 