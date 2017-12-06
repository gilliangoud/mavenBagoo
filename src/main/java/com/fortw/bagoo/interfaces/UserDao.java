/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.DbConnection;
import com.fortw.bagoo.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giel
 */
public interface UserDao {
    static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setPersoneelNr( rs.getInt("iduser") );
        user.setGebruikersnaam( rs.getString("gebruikersnaam") );
        user.setWachtwoord( rs.getString("wachtwoord") );
        user.setAangemaaktDatum( rs.getString("gemaakt-op") );
        user.setLevel( rs.getInt("level") );
        return user;
    }
    
    static public User getUser(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM c2bagoo.user WHERE"
                    + " iduser=" + id);
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<User> getAllUsers() {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            List<User> users = new ArrayList<>();
            while(rs.next())
            {
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    static public User getUserByUserNameAndPassword(String gebruikersnaam,
            String wachtwoord) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM"
                    + " c2bagoo.user WHERE gebruikersnaam=? AND wachtwoord=?");
            ps.setString(1, gebruikersnaam);
            ps.setString(2, wachtwoord);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
        return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
        
    static public boolean updateUser(User user) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET"
                    + " gebruikersnaam=?, wachtwoord=?, gemaakt-op=?, level=?,"
                    + " WHERE id=?");
            ps.setString(1, user.getGebruikersnaam());
            ps.setString(2, user.getWachtwoord());
            ps.setString(3, user.getAangemaaktDatum());
            ps.setInt(4, user.getLevel());
            ps.setInt(5, user.getPersoneelNr());
            int i = ps.executeUpdate();
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean deleteUser(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE iduser=" + id);
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean insertUser(User user) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "user VALUES (NULL, ?, ?, ?, ?)");
            ps.setString(1, user.getGebruikersnaam());
            ps.setString(2, user.getWachtwoord());
            ps.setString(3, user.getAangemaaktDatum());
            ps.setInt(4, user.getLevel());
            int i = ps.executeUpdate();
          if(i == 1) {
            return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
}
