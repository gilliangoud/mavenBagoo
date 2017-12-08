/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.models;

/**
 *
 * @author Rayman
 */
public class KlantOpzoeken {

    // Attributen
    private Integer klantNr;
    private Integer bagageNr;
    private Integer vluchtNr;
    private String achternaam;
    private String voornaam;
    private String checkInDatum;

    // Lege Constructor
    public KlantOpzoeken() {
    }

    // Constructor met alle attributen
    public KlantOpzoeken(int klantNr, int bagageNr, int vluchtNr, String achternaam, String voornaam, String checkInDatum) {
        this.klantNr = klantNr;
        this.bagageNr = bagageNr;
        this.vluchtNr = vluchtNr;
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.checkInDatum = checkInDatum;
    }

    // Constructor zonder bagageID
    public KlantOpzoeken(Integer bagageNr, Integer vluchtNr, String achternaam, String voornaam, String checkInDatum) {
        this.bagageNr = bagageNr;
        this.vluchtNr = vluchtNr;
        this.achternaam = achternaam;
        this.voornaam = voornaam;
        this.checkInDatum = checkInDatum;
    }

    /**
     * @return the klantNr
     */
    public Integer getKlantNr() {
        return klantNr;
    }

    /**
     * @param klantNr the klantNr to set
     */
    public void setKlantNr(Integer klantNr) {
        this.klantNr = klantNr;
    }

    /**
     * @return the bagageNr
     */
    public Integer getBagageNr() {
        return bagageNr;
    }

    /**
     * @param bagageNr the bagageNr to set
     */
    public void setBagageNr(Integer bagageNr) {
        this.bagageNr = bagageNr;
    }

    /**
     * @return the vluchtNr
     */
    public Integer getVluchtNr() {
        return vluchtNr;
    }

    /**
     * @param vluchtNr the vluchtNr to set
     */
    public void setVluchtNr(Integer vluchtNr) {
        this.vluchtNr = vluchtNr;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @return the checkInDatum
     */
    public String getCheckInDatum() {
        return checkInDatum;
    }

    /**
     * @param checkInDatum the checkInDatum to set
     */
    public void setCheckInDatum(String checkInDatum) {
        this.checkInDatum = checkInDatum;
    }

}
