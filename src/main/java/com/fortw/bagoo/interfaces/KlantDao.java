/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.DbConnection;
import com.fortw.bagoo.models.Klant;
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
public interface KlantDao {
    static Klant extractKlantFromResultSet(ResultSet rs) throws SQLException {
        Klant klant = new Klant();
        klant.setKlantNr( rs.getInt("idklant") );
        klant.setVoorNaam(rs.getString("voornaam"));
        klant.setTussenVoegsel(rs.getString("tussenvoegsel"));
        klant.setAchterNaam(rs.getString("achternaam"));
        klant.setWoonplaats( rs.getString("woonplaats") );
        klant.setStraat( rs.getString("huisnummer") );
        klant.setStraat( rs.getString("straat") );
        klant.setPostcode( rs.getString("postcode") );
        klant.setLand( rs.getString("land") );
        klant.setTelefoonNr( rs.getString("telefoon") );
        klant.setEmail( rs.getString("email") );
        
        return klant;
    }
    
    static public Klant getKlant(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klant WHERE"
                    + " idklant=" + id);
            if(rs.next())
            {
                return extractKlantFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<Klant> getAllKlanten() {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klant");
            List<Klant> klanten = new ArrayList<>();
            while(rs.next())
            {
                Klant klant = extractKlantFromResultSet(rs);
                klanten.add(klant);
            }
            return klanten;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<Klant> getKlantenByAchternaam(String naam) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klant WHERE"
                    + " achternaam=" + naam);
            List<Klant> klanten = new ArrayList<>();
            while(rs.next())
            {
                Klant klant = extractKlantFromResultSet(rs);
                klanten.add(klant);
            }
            return klanten;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    // DEZE IS NIET HELEMAAL OKLEEE, DELETE PLZ IF POSSIBRU
    // PLZZZ REALLY
    // IM SUUUUPER SEERIAL
    public static List<Klant> getKlantenByField(String field, String query) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klant WHERE"
                    + " " + field + "=" + query);
            List<Klant> klanten = new ArrayList<>();
            while(rs.next())
            {
                Klant klant = extractKlantFromResultSet(rs);
                klanten.add(klant);
            }
            return klanten;
        } catch (SQLException ex) {
        }
        return null;
    }
     
    static public boolean updateKlant(Klant klant) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE klant SET"
                    + " voornaam=?, tussenvoegsel=?, achternaam=?, woonplaats=?, straat=?, huisnummer=?, postcode=?, land=?, telefoon=?, email=?"
                    + " WHERE idklant=?");
            ps.setString(1, klant.getVoorNaam());
            ps.setString(2, klant.getTussenVoegsel());
            ps.setString(3, klant.getAchterNaam());
            ps.setString(4, klant.getWoonplaats());
            ps.setString(5, klant.getStraat());
            ps.setString(6, klant.getTelefoonNr());
            ps.setString(7, klant.getPostcode());
            ps.setString(8, klant.getLand());
            ps.setString(9, klant.getTelefoonNr());
            ps.setString(10, klant.getEmail());
            int i = ps.executeUpdate();
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean deleteKlant(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE idklant=" + id);
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean insertKlant(Klant klant) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "user VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, klant.getVoorNaam());
            ps.setString(2, klant.getTussenVoegsel());
            ps.setString(3, klant.getAchterNaam());
            ps.setString(4, klant.getWoonplaats());
            ps.setString(5, klant.getStraat());
            ps.setString(6, klant.getTelefoonNr());
            ps.setString(7, klant.getPostcode());
            ps.setString(8, klant.getLand());
            ps.setString(9, klant.getTelefoonNr());
            ps.setString(10, klant.getEmail());
            int i = ps.executeUpdate();
          if(i == 1) {
            return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
}
