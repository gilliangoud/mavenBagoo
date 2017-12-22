/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fortw.bagoo.models.KlantOpzoeken;

/**
 *
 * @author Rayman
 */
public interface KlantOpzoekenDao {

    static KlantOpzoeken extractKlantOpzoekenFromResultSet(ResultSet rs) throws SQLException {
        KlantOpzoeken klantopzoeken = new KlantOpzoeken();
        klantopzoeken.setKlantNr(rs.getInt("idklant"));
        klantopzoeken.setBagageNr(rs.getInt("idbagage"));
        klantopzoeken.setVluchtNr(rs.getInt("vluchtnr"));
        klantopzoeken.setAchternaam(rs.getString("achternaam"));
        klantopzoeken.setVoornaam(rs.getString("voornaam"));
        klantopzoeken.setCheckInDatum(rs.getString("checkInDatum"));

        return klantopzoeken;
    }

    static public KlantOpzoeken getKlantenOpzoeken(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ramon_KlantenOpzoekenScherm WHERE"
                    + " idklant=" + id);
            if (rs.next()) {
                return extractKlantOpzoekenFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<KlantOpzoeken> getAllKlantenOpzoeken() {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ramon_KlantenOpzoekenScherm");
            List<KlantOpzoeken> klantopzoekenl = new ArrayList<>();
            while (rs.next()) {
                KlantOpzoeken klantenopzoeken = extractKlantOpzoekenFromResultSet(rs);
                klantopzoekenl.add(klantenopzoeken);
            }
            return klantopzoekenl;

        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<KlantOpzoeken> getKlantOpzoekenByAchternaam(String achternaam) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ramon_KlantenOpzoekenScherm WHERE"
                    + " achternaam=" + achternaam);
            List<KlantOpzoeken> klantopzoekenl = new ArrayList<>();
            while (rs.next()) {
                KlantOpzoeken klantopzoeken = extractKlantOpzoekenFromResultSet(rs);
                klantopzoekenl.add(klantopzoeken);
            }
            return klantopzoekenl;

        } catch (SQLException ex) {
        }
        
        return null;
    }

    static public boolean updateKlantOpzoeken(KlantOpzoeken klantopzoeken) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Ramon_KlantenOpzoekenScherm SET"
                    + " achternaam=?, voornaam=?, checkInDatum=?"
                    + " WHERE idklant=?");
            ps.setString(1, klantopzoeken.getAchternaam());
            ps.setString(2, klantopzoeken.getVoornaam());
            ps.setString(3, klantopzoeken.getCheckInDatum());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean deleteBagage(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Ramon_KlantenOpzoekenScherm WHERE idklant=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean insertBagage(KlantOpzoeken klantopzoeken) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "Ramon_KlantenOpzoekenScherm VALUES (NULL, ?, ?, ?)");
            ps.setString(1, klantopzoeken.getAchternaam());
            ps.setString(2, klantopzoeken.getVoornaam());
            ps.setString(3, klantopzoeken.getCheckInDatum());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
}
