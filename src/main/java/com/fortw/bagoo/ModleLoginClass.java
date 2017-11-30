/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anouar
 */
public class ModleLoginClass {
    Connection conection;
    public ModleLoginClass() {
        
       conection= MysqlConnection.connector();
       if(conection == null) System.exit(1);
    }
        public boolean isDbConnected(){
        try {
           return !conection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
           
        }
        
        }
 public boolean islogin(String user, String pass){
     PreparedStatement preparedStatement;
     ResultSet resultSet;
     String query= "SELECT * FROM c2bagoo.user WHERE gebruikersnaam =? and wachtwoord =?";
 
     try {
         preparedStatement = conection.prepareStatement(query);
         preparedStatement.setString(1, user);
         preparedStatement.setString(2, pass);
         
         resultSet = preparedStatement.executeQuery();
         if(resultSet.next()){
         return true;
         }else{ return false;}
     } catch (Exception e) {
     } return false;


 }
    
}
