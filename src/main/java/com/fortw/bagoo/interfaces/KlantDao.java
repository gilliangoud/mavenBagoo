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
 * Klant Data Acces Object.
 * Voorziet de koppeling tussen de obejcten en de database tabellen.
 * Vereist een Klant klasse overeenkomend met deze interface.
 * @author Giel
 */
public interface KlantDao {

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
    
    /**
     *  Haalt 1 klant uit de tabel users waarin de primary key "userid" matcht
     * met de gegeven parameter.
     * @param id Het klantID van de klant die je op wilt vragen.
     * @return gevuld klant object of null als er geen resultaat is.
     */
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
    
    /**
     *  Geeft een lijst gevuld met klant objecten van alle entries in de 
     *  database.
     * @return List vol met klant objecten.
     */
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
    
    /**
     * Zoekt een klant in de database overeenkomend met de gegeven achternaam
     * 
     * @param naam De achternaam van de gewilde Klant.
     * @return De gevonden klant of null bij geen resultaten.
     */
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
    
    /**
     * Zoekt klanten in de database overeenkomend met de gegeven field &
     * de query.
     * de attributen of "field" waarop gezocht wordt horen gelijknamig met de 
     * database colommen te zijn.
     *
     * @param field Het attribuut waarin gezocht wordt, bijv. achternaam.
     * @param query het referentie of een deel ervan waarnaar gezocht wordt
     * @return De gevonden klanten of null bij geen resultaten.
     */
    public static List<Klant> getKlantenByField(String field, String query) {
        Connection connection = DbConnection.Connect();
        if(connection == null) System.exit(1);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM klant WHERE"
                    + " " + field + " LIKE " + "\"%" + query + "%\"");
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
     
    /**
     * Om een veranderd klant object naar de database te sturen.
     * @param klant Het klant object waar verandering aan toe is gebracht.
     * @return True als de update gelukt is, False als er een of andere fout
     * is opgetreden.
     */
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
    
    /**
     *  Verwijder een klant uit de database via het ID van het object.
     * @param id het gegeven ID of klantNr.
     * @return True bij succes, False als er een of andere fout is opgetreden. 
     */
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
    
    /**
     * Creëer een nieuwe klant in de database.
     * @param klant Het klant object met alle attributen erbij die naar de 
     * database mag.
     * @return True bij succes, False als er een of andere fout is opgetreden.
     */    
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
