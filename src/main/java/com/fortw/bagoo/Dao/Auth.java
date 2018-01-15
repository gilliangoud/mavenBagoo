/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.Dao;

import com.fortw.bagoo.models.User;

/**
 *
 * @author gilli
 */
public class Auth {
    
    private static User currentUser;
    
    public static User getUser() {
        return currentUser;
    }

    public static void setUser(User user) {
        Auth.currentUser = user;
    }
    
}
