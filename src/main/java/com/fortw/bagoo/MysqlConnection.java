/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.sql.*;

/**
 *
 * @author Anouar
 */
public class MysqlConnection {

    public static Connection connector() {
        try {
      
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","8XSrt+sa");
            return conn;
        } catch (Exception e) {return null;
        }
        
        
    }
    
}
    

