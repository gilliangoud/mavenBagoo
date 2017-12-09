/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.interfaces;

import com.fortw.bagoo.DbConnection;
import com.fortw.bagoo.models.Claim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Claim  Data Acces Object.
 * Voorziet de koppeling tussen de obejcten en de database tabellen.
 * Vereist een Claim klasse overeenkomend met deze interface.
 * @author Giel
 */
public interface ClaimDao {

    /**
     * extraheert de individuele attributen voor iedere resultaat uit de
     * gemaakte sql query.
     * 
     * hoort eigenlijk private te zijn. dit is nog niet mogelijk.
     * 
     * @param rs  de "resultset uit de gemaakte SQL query"
     * @return compleet klant object met toegevoegde attributen.
     * @throws SQLException
     */
    static Claim extractClaimFromResultSet(ResultSet rs) throws SQLException {
        Claim claim = new Claim();
        claim.setKlantennummer( rs.getInt("klantennummer") );
        claim.setDatum(rs.getString("datum"));
        claim.setReden(rs.getString("reden"));
        
        
        return claim;
    }
      public static List<Claim> getAllClaims() {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM claim");
            List<Claim> claims = new ArrayList<>();
            while(rs.next())
            {
                Claim claim = extractClaimFromResultSet(rs);
                claims.add(claim);
            }
            return claims;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    /**
     *  Haalt 1 klantennummer uit de tabel claim waarin de primary key "klantennummer" matcht
     * met de gegeven parameter.
     * @param klantennummer  Het klantID van de klant die je op wilt vragen.
     * @return gevuld claim object of null als er geen resultaat is.
     */
    static public Claim getClaim(int klantennummer) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM claim WHERE"
                    + " klantennummer=" + klantennummer);
            if(rs.next())
            {
                return extractClaimFromResultSet(rs);
            }
        } catch (SQLException ex) {
        }
        return null;
    }
    
    
    
    /**
     * Zoekt claims in de database overeenkomend met de gegeven field &
     * de query.
     * de attributen of "field" waarop gezocht wordt horen gelijknamig met de 
     * database colommen te zijn.
     *
     * @param field Het attribuut waarin gezocht wordt, bijv. klantennummer
     * @param query het referentie of een deel ervan waarnaar gezocht wordt
     * @return De gevonden klanten of null bij geen resultaten.
     */
    public static List<Claim> getClaimsByField(String field, String query) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM claim WHERE"
                    + " " + field + " LIKE " + "\"%" + query + "%\"");
            List<Claim> claims = new ArrayList<>();
            while(rs.next())
            {
                Claim claim = extractClaimFromResultSet(rs);
                claims.add(claim);
            }
            return claims;
        } catch (SQLException ex) {
        }
        return null;
    }
     
    
    
  
}
