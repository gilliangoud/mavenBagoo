/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

import com.fortw.bagoo.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Giel
 */
public class User {
    private int personeelNr;
    private String gebruikersnaam;
    private String wachtwoord;
    private String aangemaaktDatum;
    private int level;
    
    /**
     *
     */
    public User(){
    }
    
    /**
     *
     * @param personeelNr
     * @param gebruikersnaam
     * @param wachtwoord
     * @param aangemaaktDatum
     * @param level
     */
    public User(int personeelNr, String gebruikersnaam, String wachtwoord,
            String aangemaaktDatum, int level){
        this.personeelNr = personeelNr;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.aangemaaktDatum = aangemaaktDatum;
        this.level = level;
    }
    
    /**
     *
     * @param gebruikersnaam
     * @param wachtwoord
     * @param level
     */
    public User(String gebruikersnaam, String wachtwoord,
            String aangemaaktDatum, int level){
        //this.personeelNr = personeelNr;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.aangemaaktDatum = aangemaaktDatum;
        this.level = level;
    }

    /**
     * @return the personeelNr
     */
    public int getPersoneelNr() {
        return personeelNr;
    }

    /**
     * @return the gebruikersnaam
     */
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    /**
     * @param gebruikersnaam the gebruikersnaam to set
     */
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    /**
     * @return the wachtwoord
     */
    public String getWachtwoord() {
        return wachtwoord;
    }

    /**
     * @param wachtwoord the wachtwoord to set
     */
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    /**
     * @return the aangemaaktDatum
     */
    public String getAangemaaktDatum() {
        return aangemaaktDatum;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @param personeelNr the personeelNr to set
     */
    public void setPersoneelNr(int personeelNr) {
        this.personeelNr = personeelNr;
    }

    /**
     * @param aangemaaktDatum the aangemaaktDatum to set
     */
    public void setAangemaaktDatum(String aangemaaktDatum) {
        this.aangemaaktDatum = aangemaaktDatum;
    }
    
    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setPersoneelNr( rs.getInt("iduser") );
        user.setGebruikersnaam( rs.getString("gebruikersnaam") );
        user.setWachtwoord( rs.getString("wachtwoord") );
        user.setAangemaaktDatum( rs.getString("gemaakt-op") );
        user.setLevel( rs.getInt("level") );
        return user;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public User getUser(int id) {
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
    
    /**
     *
     * @param gebruikersnaam
     * @param wachtwoord
     * @return
     */
    public User getUserByUserNameAndPassword(String gebruikersnaam,
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
    
    /**
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user) {
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
    
    /**
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
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
    
    /**
     *
     * @param id
     * @return
     */
    public boolean deleteUser(int id) {
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
}
