
/* Programma: MavenBagoo    
*  @Author Ramon Mocking
*  Soort: Java Class
*  Doel: In deze class worden de getters en setters voor klantendata gemaakt,
*  deze gebruik ik om de data in een tableview weer te geven. 
 */
package com.fortw.bagoo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KlantenData {

    // Attributen
    private final StringProperty bagageNummer;
    private final StringProperty flightNummer;
    private final StringProperty achternaam;
    private final StringProperty voornaam;
    private final StringProperty checkInDatum;

    // Constructor
    public KlantenData(String bagageNummer, String flightNummer, String achternaam, String voornaam, String checkInDatum) {
        this.bagageNummer = new SimpleStringProperty(bagageNummer);
        this.flightNummer = new SimpleStringProperty(flightNummer);
        this.achternaam = new SimpleStringProperty(achternaam);
        this.voornaam = new SimpleStringProperty(voornaam);
        this.checkInDatum = new SimpleStringProperty(checkInDatum);
    }

    // Getters
    public String getBagageNummer() {
        return bagageNummer.get();
    }

    public String getFlightNummer() {
        return flightNummer.get();
    }

    public String getAchternaam() {
        return achternaam.get();
    }

    public String getVoornaam() {
        return voornaam.get();
    }

    public String getCheckInDatum() {
        return checkInDatum.get();
    }

    // Setters
    public void setBagageNummer(String value) {
        bagageNummer.set(value);
    }

    public void setFlightNummer(String value) {
        flightNummer.set(value);
    }

    public void setAchternaam(String value) {
        achternaam.set(value);
    }

    public void setVoornaam(String value) {
        voornaam.set(value);
    }

    public void setCheckInDatum(String value) {
        checkInDatum.set(value);
    }

    // String property values
    public StringProperty bagageNummerProperty() {
        return bagageNummer;
    }

    public StringProperty flightNummerProperty() {
        return flightNummer;
    }

    public StringProperty achternaamProperty() {
        return achternaam;
    }

    public StringProperty voornaamProperty() {
        return voornaam;
    }

    public StringProperty checkInDatumProperty() {
        return checkInDatum;
    }

}
