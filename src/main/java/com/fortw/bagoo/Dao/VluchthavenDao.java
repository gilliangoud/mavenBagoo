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
import com.fortw.bagoo.models.Vluchthaven;

/**
 *
 * @author Rayman
 */
public interface VluchthavenDao {

    static Vluchthaven extractFromResultSet(ResultSet rs) throws SQLException {
        Vluchthaven vluchthaven = new Vluchthaven();
        vluchthaven.setIata(rs.getString("iata"));
        vluchthaven.setLocatie(rs.getString("locatie"));
        vluchthaven.setLand(rs.getString("land"));
        vluchthaven.setTijdzone(rs.getString("tijdzone"));
        vluchthaven.setDagLichtBesparing(rs.getBoolean("daglichtbesparing"));
        vluchthaven.setNaam(rs.getString("naam"));

        return vluchthaven;
    }

    static public Vluchthaven getVluchthaven(String id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vluchthavens WHERE"
                    + " iata=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Vluchthaven> getAllVluchthavens() {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vluchthavens");
            List<Vluchthaven> vluchthavens = new ArrayList<>();
            while (rs.next()) {
                Vluchthaven vluchthaven = extractFromResultSet(rs);
                vluchthavens.add(vluchthaven);
            }
            return vluchthavens;
        } catch (SQLException ex) {
        }
        return null;
    }

    static public boolean updateVluchthaven(Vluchthaven vluchthaven) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE vluchthavens SET"
                    + " locatie=?, land=?, tijdzone=?, daglichtbesparing=?, naam=?"
                    + " WHERE iata=?");
            
            ps.setString(1, vluchthaven.getLocatie());
            ps.setString(2, vluchthaven.getLand());
            ps.setString(3, vluchthaven.getTijdzone());
            ps.setBoolean(4, vluchthaven.getDagLichtBesparing());
            ps.setString(5, vluchthaven.getNaam());
            ps.setString(6, vluchthaven.getIata());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean deleteVluchthaven(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM vluchthavens WHERE iata=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean insertVluchthaven(Vluchthaven vluchthaven) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "vluchthavens VALUES (?, ?, ?, ?, ?, ?)");
            
            ps.setString(1, vluchthaven.getIata());
            ps.setString(2, vluchthaven.getLocatie());
            ps.setString(3, vluchthaven.getLand());
            ps.setString(4, vluchthaven.getTijdzone());
            ps.setBoolean(5, vluchthaven.getDagLichtBesparing());
            ps.setString(3, vluchthaven.getNaam());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
}
