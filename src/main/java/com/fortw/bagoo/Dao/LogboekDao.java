/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.Dao;

import com.fortw.bagoo.models.Logboek;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.fortw.bagoo.models.Vermissing;

/**
 *
 * @author Rayman
 */
public interface LogboekDao {

    static Logboek extractFromResultSet(ResultSet rs) throws SQLException {
        Logboek logboek = new Logboek();
        logboek.setLogboekNr(rs.getInt("idlogboek"));
        logboek.setDatum(rs.getDate("datum"));
        logboek.setEvent(rs.getString("event"));
        logboek.setOpmerking(rs.getString("opmerking"));
        //logboek.setOpmerking("string...");
        logboek.setVermissingNr(rs.getInt("idvermissing"));
        
        return logboek;
    }

    static public Logboek getById(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logboek WHERE"
                    + " idlogboek=" + id);
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Logboek> getAll() {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logboek");
            List<Logboek> logboeken = new ArrayList<>();
            while (rs.next()) {
                Logboek logboek = extractFromResultSet(rs);
                logboeken.add(logboek);
            }
            return logboeken;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Logboek> getAllByVermissing(Vermissing vermissing) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logboek WHERE"
                    + " idvermissing=" + vermissing.getVermissingNr());
            List<Logboek> logboeken = new ArrayList<>();
            while (rs.next()) {
                Logboek logboek = extractFromResultSet(rs);
                logboeken.add(logboek);
            }
            return logboeken;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public static List<Logboek> getAllByVermissing(int vermissingid) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM logboek WHERE"
                    + " idvermissing=" + vermissingid);
            List<Logboek> logboeken = new ArrayList<>();
            while (rs.next()) {
                Logboek logboek = extractFromResultSet(rs);
                logboeken.add(logboek);
            }
            return logboeken;
        } catch (SQLException ex) {
            System.out.println("+++" + ex);
        }
        return null;
    }

    static public boolean update(Logboek logboek) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE logboek SET"
                    + " datum=?, event=?, opmerking=?"
                    + " WHERE idlogboek=?");
            ps.setDate(1, logboek.getDatum());
            ps.setString(2, logboek.getEvent());
            ps.setString(3, logboek.getOpmerking());
            ps.setInt(4, logboek.getLogboekNr());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean delete(Logboek logboek) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM logboek WHERE idlogboek=" + logboek.getLogboekNr());
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean insert(Logboek logboek) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "logboek VALUES (NULL, ?, ?, ?, ?)");
            ps.setDate(1, logboek.getDatum());
            ps.setString(2, logboek.getEvent());
            ps.setString(3, logboek.getOpmerking());
            ps.setInt(4, logboek.getVermissingNr());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("===" + ex);
        }
        return false;
    }
}
