/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;

/**
 *
 * @author gkalianan
 */
public class User {

    private Integer id;
    private String name;
    private String pass;
    private Integer age;
    private String statusRunning;
    private boolean control;
    public User() {
     this.statusRunning= "STOPPED";   
    }

    public User(String name, String pass, Integer age) {
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.statusRunning= "STOPPED";
    }

    public User(Integer id, String name, String pass, Integer age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.statusRunning= "STOPPED";
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass ) {
        this.pass = pass;
    }
    
        public boolean getControl() {
        return control;
    }
    public void setControl(boolean control ) {
        this.control = control;
    }
    
   public String getStatusRunning() {
        return statusRunning;
    }
   
   
/**
 * Set status for downloads RUNNING,STOPPED,STARTING,STOPING
 * @param statusRunning 
 */
    public void setStatusRunning(String statusRunning) {
        this.statusRunning = statusRunning;
    }

}
