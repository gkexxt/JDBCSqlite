/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;

import java.util.List;

/**
 *
 * @author gkalianan
 */
public interface UserDaoInterface {

    User getUser(int id);

    List<User> getAllUsers();

    User getUserByUserNameAndPassword(String user, String pass);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

}
