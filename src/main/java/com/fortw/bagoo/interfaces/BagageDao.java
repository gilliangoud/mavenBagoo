/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fortw.bagoo.models.Bagage;

/**
 *
 * @author Rayman
 */
public interface BagageDao {
    static Bagage extractKlantFromResultSet(ResultSet rs) throws SQLException {
        Bagage bagage = new Bagage();
        bagage.setBagageNr( rs.getInt("idbagage") );
        bagage.setType(rs.getString("type"));
        bagage.setMerk(rs.getString("merk"));
        bagage.setKleur(rs.getString("kleur"));
        bagage.setKleur2( rs.getString("kleur2") );
        bagage.setGewicht( rs.getString("gewicht") );
        bagage.setOpmerking( rs.getString("opmerking") );
        bagage.setBreedte( rs.getString("breedte") );
        bagage.setDiepte( rs.getString("diepte") );
        bagage.setLocatieNr( rs.getInt("Locaties_idLocaties") );
        bagage.setVluchtNr( rs.getInt("vlucht_vluchtnr") );
        
        return bagage;
    }
    
    static public Bagage getBagage(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bagage WHERE"
                    + " idbagage=" + id);
            if(rs.next())
            {
                return extractKlantFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<Bagage> getAllBagage() {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bagage");
            List<Bagage> bagagestukken = new ArrayList<>();
            while(rs.next())
            {
                Bagage bagage = extractKlantFromResultSet(rs);
                bagagestukken.add(bagage);
            }
            return bagagestukken;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<Bagage> getBagageByType(String type) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bagage WHERE"
                    + " type=" + type);
            List<Bagage> bagagestukken = new ArrayList<>();
            while(rs.next())
            {
                Bagage bagage = extractKlantFromResultSet(rs);
                bagagestukken.add(bagage);
            }
            return bagagestukken;
        } catch (SQLException ex) {
        }
        return null;
    }
     
    static public boolean updateBagage(Bagage bagage) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE bagage SET"
                    + " type=?, merk=?, kleur=?, kleur2=?, gewicht=?, opmerking=?, breedte=?, hoogte=?, diepte=?"
                    + " WHERE idbagage=?");
            ps.setString(1, bagage.getType());
            ps.setString(2, bagage.getMerk());
            ps.setString(3, bagage.getKleur());
            ps.setString(4, bagage.getKleur2());
            ps.setString(5, bagage.getGewicht());
            ps.setString(6, bagage.getOpmerking());
            ps.setString(7, bagage.getBreedte());
            ps.setString(8, bagage.getHoogte());
            ps.setString(9, bagage.getDiepte());
            int i = ps.executeUpdate();
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean deleteBagage(int id) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM bagage WHERE idbagage=" + id);
          if(i == 1) {
        return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
    
    static public boolean insertBagage(Bagage bagage) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "bagage VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, bagage.getType());
            ps.setString(2, bagage.getMerk());
            ps.setString(3, bagage.getKleur());
            ps.setString(4, bagage.getKleur2());
            ps.setString(5, bagage.getGewicht());
            ps.setString(6, bagage.getOpmerking());
            ps.setString(7, bagage.getBreedte());
            ps.setString(8, bagage.getHoogte());
            ps.setString(9, bagage.getDiepte());
            int i = ps.executeUpdate();
          if(i == 1) {
            return true;
          }
        } catch (SQLException ex) {
        }
        return false;
    }
}
