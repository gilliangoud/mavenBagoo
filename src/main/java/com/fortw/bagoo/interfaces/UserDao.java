/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.models.User;
import java.util.Set;

/**
 *
 * @author Giel
 */
public interface UserDao {
    User getUser();
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword();
    boolean insertUser();
    boolean updateUser();
    boolean deleteUser();
    
}
