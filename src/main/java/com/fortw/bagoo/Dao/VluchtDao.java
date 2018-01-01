/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.Dao;

import com.fortw.bagoo.models.Vlucht;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rayman
 */
public interface VluchtDao {

    static Vlucht extractFromResultSet(ResultSet rs) throws SQLException {
        Vlucht vlucht = new Vlucht();
        vlucht.setVluchtNr(rs.getString("vluchtnr"));
        vlucht.setVliegtuigmaatschappij(rs.getString("vliegtuigmaatschappij"));
        vlucht.setVan(rs.getString("van"));
        vlucht.setNaar(rs.getString("naar"));

        return vlucht;
    }

    static public Vlucht getVlucht(String id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {            
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM "
                    + "vlucht WHERE vluchtnr=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static List<Vlucht> getAllVluchten() {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vlucht");
            List<Vlucht> vluchten = new ArrayList<>();
            while (rs.next()) {
                Vlucht vlucht = extractFromResultSet(rs);
                vluchten.add(vlucht);
            }
            return vluchten;
        } catch (SQLException ex) {
        }
        return null;
    }

    static public boolean updateVlucht(Vlucht vlucht) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE vlucht SET"
                    + " vliegtuigmaatschappij=?, van=?, naar=?"
                    + " WHERE vluchtnr=?");
            
            ps.setString(1, vlucht.getVliegtuigmaatschappij());
            ps.setString(2, vlucht.getVan());
            ps.setString(3, vlucht.getNaar());
            ps.setString(4, vlucht.getVluchtNr());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean deleteVlucht(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM vlucht WHERE vluchtnr=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean insertVlucht(Vlucht vlucht) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "vlucht VALUES (?, ?, ?, ?)");
            
            ps.setString(1, vlucht.getVluchtNr());
            ps.setString(2, vlucht.getVliegtuigmaatschappij());
            ps.setString(3, vlucht.getVan());
            ps.setString(4, vlucht.getNaar());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
}
