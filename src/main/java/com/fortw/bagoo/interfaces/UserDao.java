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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User Data Acces Object.
 * Voorziet de koppeling tussen de obejcten en de database tabellen.
 * 
 * @author Giel
 */
public interface UserDao {

    /**
     * extraheert de individuele attributen voor iedere resultaat uit de
     * gemaakte sql query.
     * 
     * hoort eigenlijk private te zijn. dit is nog niet mogelijk.
     * 
     * @param rs  de "resultset uit de gemaakte SQL query"
     * @return compleet user object met toegevoegde attributen.
     * @throws SQLException
     */
    static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setPersoneelNr( rs.getInt("iduser") );
        user.setGebruikersnaam( rs.getString("gebruikersnaam") );
        user.setWachtwoord( rs.getString("wachtwoord") );
        user.setAangemaaktDatum( rs.getString("gemaakt-op") );
        user.setLevel( rs.getInt("level") );
        return user;
    }
    
    /**
     *  Haalt 1 user uit de tabel users waarin de primary key "userid" matcht
     * met de gegeven parameter.
     * @param id Het userID van de user die je op wilt vragen.
     * @return gevuld User object of null als er geen resultaat is.
     */
    static public User getUser(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE"
                    + " iduser=" + id);
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    /**
     *  Geeft een lijst gevuld met User objecten van alle entries in de 
     *  database.
     * @return List vol met User objecten.
     */
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
     * Zoekt een User in de database overeenkomend met de gegeven username &
     * het gegeven wachtwoord.
     *
     * @param gebruikersnaam De Gebruikersnaam van de User.
     * @param wachtwoord    Het wachtwoord van de User.
     * @return De gevonden User of null bij geen resultaten.
     */
    static public User getUserByUserNameAndPassword(String gebruikersnaam,
            String wachtwoord) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM"
                    + " user WHERE gebruikersnaam=? AND wachtwoord=?");
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
     * Om een veranderd User object naar de database te sturen.
     * @param user Het object waar veranderingen aan toe zijn gebracht.
     * @return True als de update gelukt is, False als er een of andere fout
     * is opgetreden.
     */
    static public boolean updateUser(User user) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE user SET"
                    + " gebruikersnaam=?, wachtwoord=?, level=?"
                    + " WHERE iduser=?");
            ps.setString(1, user.getGebruikersnaam());
            ps.setString(2, user.getWachtwoord());
            //ps.setString(3, user.getAangemaaktDatum());
            ps.setInt(3, user.getLevel());
            ps.setInt(4, user.getPersoneelNr());
            int i = ps.executeUpdate();
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    /**
     *  Verweider een User uit de database via het ID van het object.
     * @param id het gegeven ID of medewerkerNr.
     * @return True bij succes, False als er een of andere fout is opgetreden. 
     */
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
    
    /**
     *  Creëer een nieuwe user in de database.
     * @param user Het user object met alle attributen die in de database moet
     * komen.
     * @return True bij succes, False als er een of andere fout is opgetreden.
     */
    static public boolean insertUser(User user) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "user VALUES (NULL, ?, ?, ?, ?)");
            ps.setString(1, user.getGebruikersnaam());
            ps.setString(2, user.getWachtwoord());
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            ps.setString(3, date);
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
