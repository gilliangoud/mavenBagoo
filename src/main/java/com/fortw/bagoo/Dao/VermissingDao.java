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
import com.fortw.bagoo.models.Vermissing;
import com.fortw.bagoo.models.User;

/**
 *
 * @author Rayman
 */
public interface VermissingDao {

    static Vermissing extractVermissingFromResultSet(ResultSet rs) throws SQLException {
        Vermissing vermissing = new Vermissing();
        vermissing.setVermissingNr(rs.getInt("idvermissing"));
        vermissing.setDatumGevonden(rs.getString("datum-gevonden"));
        vermissing.setTijdGevonden(rs.getString("tijd-gevonden"));
        vermissing.setVluchthaven(VluchthavenDao.getVluchthaven(rs.getString("vluchthavens_iata")));
        vermissing.setKlant(KlantDao.getKlant(rs.getInt("klant_idklant")));
        vermissing.setBagage(BagageDao.getBagage(rs.getInt("bagage_idbagage")));
        vermissing.setAangemaakt(rs.getString("aangemaakt"));
        vermissing.setLaatsteUpdate(rs.getString("laatste-update"));
        vermissing.setBagageLabel(rs.getString("bagagelabel"));
        vermissing.setVlucht(VluchtDao.getVlucht(rs.getString("vlucht_vluchtnr")));
        vermissing.setUserAangemaakt(UserDao.getUser(rs.getInt("user_iduser_aangemaakt")));
        vermissing.setUserBewerkt(UserDao.getUser(rs.getInt("user_iduser_bewerkt")));

        return vermissing;
    }

    static public Vermissing getVermissing(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vermissing WHERE"
                    + " idvermissing=" + id);
            if (rs.next()) {
                return extractVermissingFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Vermissing> getAllVermissingen() {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vermissing");
            List<Vermissing> vermissingen = new ArrayList<>();
            while (rs.next()) {
                Vermissing vermissing = extractVermissingFromResultSet(rs);
                vermissingen.add(vermissing);
            }
            return vermissingen;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static List<Vermissing> getVermissingByDatumGevonden(String datumGevonden) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vermissing WHERE"
                    + " datumGevonden=" + datumGevonden);
            List<Vermissing> vermissingen = new ArrayList<>();
            while (rs.next()) {
                Vermissing vermissing = extractVermissingFromResultSet(rs);
                vermissingen.add(vermissing);
            }
            return vermissingen;
        } catch (SQLException ex) {
        }
        return null;
    }

    static public boolean updateVermissing(Vermissing vermissing) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE vermissing SET"
                    + " datumGevonden=?, tijdGevonden=?, aangemaakt=?, laatsteUpdate=?, bagageLabel=?, vluchtNr=?, userAangemaakt=?, userBewerkt=?"
                    + " WHERE idbagage=?");
            ps.setString(1, vermissing.getDatumGevonden());
            ps.setString(1, vermissing.getTijdGevonden());
            ps.setString(4, vermissing.getAangemaakt());
            ps.setString(5, vermissing.getLaatsteUpdate());
            ps.setString(6, vermissing.getBagageLabel());
            //ps.setInt(7, vermissing.getVlucht());
            //ps.setString(8, vermissing.getUserAangemaakt());
            //ps.setString(9, vermissing.getUserBewerkt());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean deleteVermissing(int id) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM vermissing WHERE idvermissing=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    static public boolean insertVermissing(Vermissing vermissing) {
        Connection connection = DbConnection.Connect();
        if (connection == null) {
            System.exit(1);
        }
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO "
                    + "vermissing VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, vermissing.getDatumGevonden());
            ps.setString(1, vermissing.getTijdGevonden());
            ps.setString(4, vermissing.getAangemaakt());
            ps.setString(5, vermissing.getLaatsteUpdate());
            ps.setString(6, vermissing.getBagageLabel());
            //ps.setInt(7, vermissing.getVlucht());
            User user = vermissing.getUserAangemaakt();
            ps.setInt(8, user.getPersoneelNr());
            ps.setInt(9, user.getPersoneelNr());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
}
