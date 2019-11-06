package DataTable;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gk
 */
public class DbCheck {

    public static void main(String[] args) {
        File f = new File("plugins.db");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("ok");
        } else {
            System.out.println("ko");
        }
        
    }
}
